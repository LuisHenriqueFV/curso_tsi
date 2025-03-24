<?php

use App\Http\Controllers\Api\ItemController;
use App\Http\Controllers\Api\CategoryController;
use App\Http\Controllers\Api\UserController;
use App\Http\Controllers\Api\AuthController;
use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

// 🟢 Rotas de filtro (ANTES das rotas dinâmicas para evitar conflitos)
Route::get('/items/filter', [ItemController::class, 'filter']);
Route::get('/categories/filter', [CategoryController::class, 'filter']);
Route::get('/users/filter', [UserController::class, 'filter']);

// 🟢 Rotas de Itens
Route::get('/items', [ItemController::class, 'index']);
Route::get('/items/{item}', [ItemController::class, 'show']);
Route::middleware('auth:sanctum')->post('/items', [ItemController::class, 'store']);
Route::middleware('auth:sanctum')->put('/items/{item}', [ItemController::class, 'update']);
Route::middleware('auth:sanctum')->delete('/items/{item}', [ItemController::class, 'destroy']);

// 🟢 Rotas de Categorias
Route::get('/categories', [CategoryController::class, 'index']);
Route::get('/categories/{category}', [CategoryController::class, 'show']);
Route::middleware('auth:sanctum')->post('/categories', [CategoryController::class, 'store']);
Route::middleware('auth:sanctum')->put('/categories/{category}', [CategoryController::class, 'update']);
Route::middleware('auth:sanctum')->delete('/categories/{category}', [CategoryController::class, 'destroy']);

// 🟢 Rotas de Usuários
Route::middleware('auth:sanctum')->get('/users', [UserController::class, 'index']);
Route::middleware('auth:sanctum')->get('/users/{user}', [UserController::class, 'show']);
Route::post('/users', [UserController::class, 'store']); // Registro sem autenticação
Route::middleware('auth:sanctum')->put('/users/{user}', [UserController::class, 'update']);
Route::middleware('auth:sanctum')->delete('/users/{user}', [UserController::class, 'destroy']);

// 🟢 Rotas de Autenticação
Route::post('/login', [AuthController::class, 'login']);
Route::post('/register', [AuthController::class, 'register']);
Route::middleware('auth:sanctum')->post('/logout', [AuthController::class, 'logout']);

// 🟢 Retornar usuário autenticado
Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return response()->json($request->user());
});
