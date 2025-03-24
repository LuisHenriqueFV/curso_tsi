<?php

namespace App\Providers;

use Illuminate\Support\Facades\Route;
use Illuminate\Foundation\Support\Providers\RouteServiceProvider as ServiceProvider;

class RouteServiceProvider extends ServiceProvider
{
    /**
     * The path to the "home" route for your application.
     *
     * Typically, users are redirected here after login.
     */
    public const HOME = '/'; // Redirecione para a página inicial

    /**
     * Define your route model bindings, pattern filters, etc.
     */
    public function boot(): void
    {
        $this->routes(function () {
            // Grupo de rotas para API
            Route::middleware('api')
                ->prefix('api')
                ->group(base_path('routes/api.php'));

            // Grupo de rotas para Web
            Route::middleware('web')
                ->group(base_path('routes/web.php'));
        });
    }
}
