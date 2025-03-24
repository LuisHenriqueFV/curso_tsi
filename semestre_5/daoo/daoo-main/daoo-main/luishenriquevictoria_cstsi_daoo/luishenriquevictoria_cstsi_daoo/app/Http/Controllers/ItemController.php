<?php

namespace App\Http\Controllers;

use App\Models\Item;
use App\Models\Category;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class ItemController extends Controller
{
    // Exibe uma lista de itens com filtros e agregação
    public function index(Request $request)
    {
        // Obtém todas as categorias
        $categories = Category::all();

        // Faz a consulta dos itens, levando em consideração os filtros (se existirem)
        $items = Item::with('category')
            ->when($request->name, function ($query) use ($request) {
                return $query->where('name', 'like', '%' . $request->name . '%');
            })
            ->when($request->category_id, function ($query) use ($request) {
                return $query->where('category_id', $request->category_id);
            })
            ->when($request->status, function ($query) use ($request) {
                return $query->where('status', $request->status);
            })
            ->paginate(10);

        // Agregação: Contagem de itens por status (perdido, achado)
        $itemCountByStatus = Item::selectRaw('status, count(*) as count')
            ->groupBy('status')
            ->pluck('count', 'status')
            ->toArray();

        // Retorna a visualização dos itens com as categorias e a agregação de status
        return view('items.index', compact('items', 'categories', 'itemCountByStatus'));
    }

    // Exibe o formulário para criar um novo item
    public function create()
    {
        $categories = Category::all(); // Carrega todas as categorias para o formulário
        return view('items.create', compact('categories'));
    }

    // Salva um novo item no banco de dados
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'description' => 'required|string',
            'category_id' => 'required|integer|exists:categories,id',
            'status' => 'required|string|in:perdido,achado',
            'date' => 'required|date',
            'contact_email' => 'nullable|email|max:255',
            'contact_phone' => 'nullable|string|max:20',
            'address' => 'nullable|string|max:255',
        ]);

        // Criando o item com os dados do formulário
        Item::create([
            'name' => $request->name,
            'description' => $request->description,
            'category_id' => $request->category_id,
            'status' => $request->status,
            'date' => $request->date,
            'contact_email' => $request->contact_email,
            'contact_phone' => $request->contact_phone,
            'user_id' => Auth::id(),
            'address' => $request->address,
        ]);

        return redirect()->route('items.index')->with('success', 'Item adicionado com sucesso!');
    }

    // Exibe os detalhes de um item específico
    public function show(Item $item)
    {
        return view('items.show', compact('item'));
    }

    // Exibe o formulário para editar um item existente
    public function edit($id)
    {
        $item = Item::findOrFail($id);

        // Verificar se o usuário autenticado é o dono do item ou se é administrador
        if ($item->user_id !== Auth::user()->id && !Auth::user()->is_admin) {
            abort(403, 'Acesso negado.');
        }

        $categories = Category::all();
        return view('items.edit', compact('item', 'categories'));
    }

    // Atualiza um item existente no banco de dados
    public function update(Request $request, $id)
    {
        // Valida os dados recebidos na requisição
        $request->validate([
            'name' => 'required|string|max:255',
            'category_id' => 'required|exists:categories,id',
            'description' => 'required|string',
            'date' => 'required|date',
            'contact_email' => 'nullable|email',
            'contact_phone' => 'nullable|string|max:15',
            'adress' => 'nullable|string|max:255',
        ]);

        $item = Item::findOrFail($id);

        // Verifica se o usuário é o proprietário do item ou se é administrador
        if ($item->user_id !== Auth::user()->id && !Auth::user()->is_admin) {
            abort(403, 'Acesso negado.');
        }

        // Atualiza os dados do item com os dados validados da requisição
        $item->update($request->only([
            'name',
            'category_id',
            'description',
            'date',
            'contact_email',
            'contact_phone',
            'address',

        ]));

        return redirect()->route('items.index')->with('success', 'Item atualizado com sucesso.');
    }

    // Remove um item do banco de dados
    public function destroy($id)
    {
        $item = Item::findOrFail($id);

        // Verifica se o usuário é o proprietário do item ou se é administrador
        if (Auth::id() !== $item->user_id && !Auth::user()->is_admin) {
            return redirect()->route('items.index')->with('error', 'Você não tem permissão para excluir este item.');
        }

        $item->delete();

        return redirect()->route('items.index')->with('success', 'Item excluído com sucesso!');
    }
}
