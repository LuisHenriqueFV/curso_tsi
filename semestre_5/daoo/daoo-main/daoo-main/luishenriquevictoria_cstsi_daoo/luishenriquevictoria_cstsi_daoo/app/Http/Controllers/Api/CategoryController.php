<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Requests\Api\StoreCategoryRequest;
use App\Http\Requests\Api\UpdateCategoryRequest;
use App\Http\Resources\Api\CategoryResource;
use App\Models\Category;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;

class CategoryController extends Controller
{
    // Lista todas as categorias
    public function index()
    {
        // Obtém o nome da categoria a partir da query string (ex: ?name=eleaaeeaae)
        $query = Category::query();

        if (request()->has('name') && request()->name != '') {
            $query->where('name', 'like', '%' . request()->name . '%');
        }

        $categories = $query->get();

        if ($categories->isEmpty()) {
            return response()->json([
                'message' => 'Nenhuma categoria encontrada.',
                'data' => [],
            ], Response::HTTP_OK);
        }

        return response()->json([
            'message' => 'Categorias recuperadas com sucesso.',
            'data' => CategoryResource::collection($categories),
        ], Response::HTTP_OK);
    }

    // Cria uma nova categoria
    public function store(StoreCategoryRequest $request)
    {
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para criar uma categoria.',
            ], Response::HTTP_FORBIDDEN);
        }
        try {
            $category = Category::create($request->validated());

            return response()->json([
                'message' => 'Categoria criada com sucesso!',
                'data' => new CategoryResource($category),
            ], Response::HTTP_CREATED);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao criar a categoria.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    // Exibe uma categoria específica
    public function show(Category $category)
    {
        if (!$category) {
            return response()->json([
                'message' => 'Categoria não encontrada.',
            ], Response::HTTP_NOT_FOUND);
        }

        return response()->json([
            'message' => 'Categoria recuperada com sucesso.',
            'data' => new CategoryResource($category),
        ], Response::HTTP_OK);
    }

    // Atualiza uma categoria existente
    public function update(UpdateCategoryRequest $request, Category $category)
    {
        // Verifica se o usuário logado é um administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para atualizar esta categoria.',
            ], Response::HTTP_FORBIDDEN);
        }
        try {
            $category->update($request->validated());

            return response()->json([
                'message' => 'Categoria atualizada com sucesso!',
                'data' => new CategoryResource($category),
            ], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao atualizar a categoria.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    // Deleta uma categoria
    // Deleta uma categoria (Apenas Admins e se não houver itens associados)
    public function destroy(Category $category)
    {
        // Verifica se o usuário logado é um administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para excluir esta categoria.',
            ], Response::HTTP_FORBIDDEN);
        }

        // Verifica se a categoria está associada a algum item
        if ($category->items()->count() > 0) {
            return response()->json([
                'message' => 'Não é possível excluir esta categoria, pois ela está associada a um ou mais itens.',
            ], Response::HTTP_CONFLICT);
        }

        try {
            $category->delete();

            return response()->json([
                'message' => 'Categoria deletada com sucesso.',
            ], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao deletar a categoria.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    //Filtrar categorias e incluir quantidade de itens associados (withCount()).
    public function filter()
    {
        $categories = Category::withCount('items')
            ->with('items')
            ->when(request('name'), fn($query, $name) => $query->where('name', 'like', "%{$name}%"))
            ->get();

        return response()->json([
            'message' => 'Categorias filtradas com sucesso.',
            'data' => $categories,
        ], Response::HTTP_OK);
    }
}
