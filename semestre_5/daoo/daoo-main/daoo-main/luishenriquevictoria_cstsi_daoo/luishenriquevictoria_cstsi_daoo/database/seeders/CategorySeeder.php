<?php

namespace Database\Seeders;

use App\Models\Category;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;


class CategorySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Desabilitar temporariamente as restrições de chave estrangeira
        DB::statement('SET FOREIGN_KEY_CHECKS=0;');

        // Limpar a tabela de categorias (irá funcionar agora)
        Category::truncate();

        // Criar categorias
        Category::factory(10)->create();

        // Reabilitar as restrições de chave estrangeira
        DB::statement('SET FOREIGN_KEY_CHECKS=1;');
    }
}
