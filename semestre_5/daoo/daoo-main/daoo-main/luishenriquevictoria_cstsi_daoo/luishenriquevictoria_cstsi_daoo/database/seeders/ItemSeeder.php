<?php

namespace Database\Seeders;

use App\Models\Item;
use Illuminate\Database\Seeder;

class ItemSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Limpar a tabela de itens
        Item::truncate();

        // Criar itens
        Item::factory(10)->create();
    }
}
