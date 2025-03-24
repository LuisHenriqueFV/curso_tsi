<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class IsAdmin
{
    public function handle(Request $request, Closure $next)
    {
        // Verifica se o usuário está autenticado e é administrador
        if (Auth::check() && Auth::user()->is_admin == 1) {
            return $next($request);
        }

        // Redireciona usuários não autorizados
        return redirect('/')->with('error', 'Você não tem permissão para acessar esta página.');
    }
}
