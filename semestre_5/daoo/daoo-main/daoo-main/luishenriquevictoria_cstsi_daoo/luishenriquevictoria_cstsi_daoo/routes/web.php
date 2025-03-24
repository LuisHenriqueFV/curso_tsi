<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ItemController;
use App\Http\Controllers\CategoryController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Auth;

// Página inicial
Route::get('/', [ItemController::class, 'index']);

// Recursos de Items, Categories e Users
Route::resource('items', ItemController::class);
Route::resource('categories', CategoryController::class);
Route::resource('users', UserController::class);

// Rota protegida para o painel de usuário após o login
Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');

// Rotas de autenticação simplificadas
Auth::routes(); // Isso gera todas as rotas de autenticação necessárias (login, registro, senha, etc.)

// Rota protegida para os itens, apenas usuários autenticados podem acessar
Route::middleware('auth')->group(function () {
    // Não é necessário definir as rotas de 'items' aqui, pois o Route::resource já as define.
    Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');
});
