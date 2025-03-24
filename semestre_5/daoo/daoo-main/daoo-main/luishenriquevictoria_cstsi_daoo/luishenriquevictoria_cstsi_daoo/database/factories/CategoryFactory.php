<?php

namespace Database\Factories;

use App\Models\Category;
use Illuminate\Database\Eloquent\Factories\Factory;

class CategoryFactory extends Factory
{
    /**
     * O nome da model que a fábrica está criando.
     *
     * @var string
     */
    protected $model = Category::class;

    /**
     * Definir os atributos para a criação de uma categoria.
     *
     * @return array
     */
    public function definition()
    {
        return [
            'name' => $this->faker->unique()->word,  // Garante que o nome será único
        ];
    }
}
