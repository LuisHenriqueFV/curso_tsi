<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Requests\Api\StoreUserRequest;
use App\Http\Requests\Api\UpdateUserRequest;
use App\Http\Resources\Api\UserResource;
use App\Models\User;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Auth;

class UserController extends Controller
{
    // Lista todos os usuários
    public function index()
    {
        // Verifica se o usuário está autenticado e é administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para visualizar os usuários.',
            ], Response::HTTP_FORBIDDEN);
        }

        $users = User::all();

        if ($users->isEmpty()) {
            return response()->json([
                'message' => 'Nenhum usuário encontrado.',
                'data' => [],
            ], Response::HTTP_OK);
        }

        return response()->json([
            'message' => 'Usuários recuperados com sucesso.',
            'data' => UserResource::collection($users),
        ], Response::HTTP_OK);
    }

    // Cria um novo usuário
    public function store(StoreUserRequest $request)
    {
        // Verifica se o usuário está autenticado e é administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para criar um usuário.',
            ], Response::HTTP_FORBIDDEN);
        }

        try {
            $user = User::create([
                'name' => $request->name,
                'email' => $request->email,
                'password' => Hash::make($request->password),
                'is_admin' => $request->is_admin ?? 0,
            ]);

            return response()->json([
                'message' => 'Usuário criado com sucesso!',
                'data' => new UserResource($user),
            ], Response::HTTP_CREATED);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao criar o usuário.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    // Exibe os detalhes de um usuário específico
    public function show(User $user)
    {
        // Verifica se o usuário está autenticado e é administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para visualizar este usuário.',
            ], Response::HTTP_FORBIDDEN);
        }

        if (!$user) {
            return response()->json([
                'message' => 'Usuário não encontrado.',
            ], Response::HTTP_NOT_FOUND);
        }

        return response()->json([
            'message' => 'Usuário recuperado com sucesso.',
            'data' => new UserResource($user),
        ], Response::HTTP_OK);
    }

    // Atualiza os dados de um usuário existente
    public function update(UpdateUserRequest $request, User $user)
    {
        // Verifica se o usuário está autenticado e é administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para atualizar este usuário.',
            ], Response::HTTP_FORBIDDEN);
        }

        try {
            $data = $request->only(['name', 'email']);
            if ($request->password) {
                $data['password'] = Hash::make($request->password);
            }

            $user->update($data);

            return response()->json([
                'message' => 'Usuário atualizado com sucesso!',
                'data' => new UserResource($user),
            ], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao atualizar o usuário.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    // Remove um usuário do banco de dados
    public function destroy(User $user)
    {
        // Verifica se o usuário está autenticado e é administrador
        if (!Auth::user() || !Auth::user()->is_admin) {
            return response()->json([
                'message' => 'Você não tem permissão para deletar este usuário.',
            ], Response::HTTP_FORBIDDEN);
        }

        try {
            $user->delete();

            return response()->json([
                'message' => 'Usuário deletado com sucesso.',
            ], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Ocorreu um erro ao deletar o usuário.',
                'error' => $e->getMessage(),
            ], Response::HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    //Filtrar usuários e incluir quantidade de itens cadastrados.
    public function filter()
    {
        // Inicializa a consulta
        $query = User::query();

        // Filtro por email, se fornecido
        if (request()->has('email')) {
            $query->where('email', 'like', '%' . request()->email . '%');
        }

        // Carrega os itens com contagem de forma eficiente
        $users = $query->withCount('items')->get(); // 'withCount' já retorna a quantidade de itens

        return response()->json([
            'message' => 'Usuários filtrados com sucesso.',
            'data' => $users,
        ], Response::HTTP_OK);
    }
}
