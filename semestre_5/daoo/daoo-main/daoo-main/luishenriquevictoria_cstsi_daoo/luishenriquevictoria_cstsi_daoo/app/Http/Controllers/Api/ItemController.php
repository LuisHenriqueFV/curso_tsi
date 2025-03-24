<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Requests\Api\StoreItemRequest;
use App\Http\Requests\Api\UpdateItemRequest;
use App\Http\Resources\Api\ItemResource;
use App\Models\Item;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;

class ItemController extends Controller
{
    // Lista todos os itens com filtros
    public function index()
    {
        // Recupera todos os itens com o relacionamento de categoria
        $items = Item::with('category')->get();

        if ($items->isEmpty()) {
            return response()->json([
                'message' => 'Nenhum item encontrado.',
                'data' => [],
            ], Response::HTTP_OK);
        }

        return response()->json([
            'message' => 'Itens recuperados com sucesso.',
            'data' => ItemResource::collection($items),
        ], Response::HTTP_OK);
    }


    // Cria um novo item
    public function store(StoreItemRequest $request)
    {
        try {
            $item = Item::create([
                'name' => $request->name,
                'description' => $request->description,
                'category_id' => $request->category_id,
                'status' => $request->status,
                'date' => $request->date,
                'contact_email' => $request->contact_email,
                'contact_phone' => $request->contact_phone,
                'address' => $request->address,
                'user_id' => Auth::user()->id,
            ]);

            return response()->json([
                'message' => 'Item criado com sucesso!',
                'data' => new ItemResource($item),
            ], Response::HTTP_CREATED);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao criar o item.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    // Exibe os detalhes de um item específico
    public function show(Item $item)
    {
        if (!$item) {
            return response()->json([
                'message' => 'Item não encontrado.',
            ], Response::HTTP_NOT_FOUND);
        }

        return response()->json([
            'message' => 'Item recuperado com sucesso.',
            'data' => new ItemResource($item),
        ], Response::HTTP_OK);
    }

    // Atualiza um item existente
    public function update(UpdateItemRequest $request, $id)
    {
        // Obtém o item com base no ID
        $item = Item::findOrFail($id);

        // Verifica se o usuário é o proprietário ou se é administrador
        if (Auth::id() !== $item->user_id && !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para atualizar este item.',
            ], Response::HTTP_FORBIDDEN);
        }

        // Atualiza os dados do item com os dados validados da requisição
        $item->update($request->validated());

        // Retorna a resposta com sucesso e os dados atualizados
        return response()->json([
            'message' => 'Item atualizado com sucesso!',
            'data' => new ItemResource($item),
        ], Response::HTTP_OK);
    }

    // Deleta um item
    public function destroy($id)
    {
        $item = Item::find($id);

        if (!$item) {
            return response()->json([
                'message' => 'Item não encontrado.',
            ], Response::HTTP_NOT_FOUND);
        }

        // Verifica se o usuário é o proprietário ou administrador
        if (Auth::id() !== $item->user_id && !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para excluir este item.',
            ], Response::HTTP_FORBIDDEN);
        }

        $item->delete();

        return response()->json([
            'message' => 'Item deletado com sucesso.',
        ], Response::HTTP_OK);
    }

    public function filter(Request $request)
    {
        // Verifica se o status fornecido é inválido
        if ($request->has('status') && !in_array($request->status, ['achado', 'perdido'])) {
            return response()->json([
                'message' => 'Nenhum item encontrado com este status.',
                'data' => [],
            ], Response::HTTP_OK);
        }

        // Inicializa a consulta
        $query = Item::query();

        // Filtro por nome
        if ($request->has('name')) {
            $query->where('name', 'like', '%' . $request->name . '%');
        }

        // Filtro por status
        if ($request->has('status')) {
            $query->where('status', $request->status);
        }

        // Filtro por categoria
        if ($request->has('category_id')) {
            $query->where('category_id', $request->category_id);
        }

        // Filtro por data
        if ($request->has('date')) {
            $query->whereDate('date', $request->date);
        }

        // Filtro por localização
        if ($request->has('address')) {
            $query->where('address', 'like', '%' . $request->address . '%');
        }

        // Contagem de status
        $statusCounts = Item::selectRaw('
            SUM(status = "achado") as total_achados,
            SUM(status = "perdido") as total_perdidos
        ')->first();

        // Obter os itens
        $items = $query->with(['user', 'category'])->get();

        return response()->json([
            'message' => 'Itens filtrados com sucesso.',
            'total_achados' => $statusCounts->total_achados ?? 0,
            'total_perdidos' => $statusCounts->total_perdidos ?? 0,
            'data' => ItemResource::collection($items),
        ], Response::HTTP_OK);
    }
}
