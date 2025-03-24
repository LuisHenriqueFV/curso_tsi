<?php

namespace Database\Factories;

use App\Models\Item;
use App\Models\Category;
use App\Models\User;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Item>
 */
class ItemFactory extends Factory
{
    /**
     * Defina o modelo de dados padrão para a fábrica.
     *
     * @return array
     */
    public function definition()
    {
        return [
            'name' => $this->faker->word(),
            'description' => $this->faker->sentence(),
            'status' => $this->faker->randomElement(['achado', 'perdido']),
            'category_id' => Category::factory(),  // Garante que a categoria será criada
            'user_id' => User::factory(),  // Garante que o usuário será criado
            'date' => $this->faker->date(),
            'contact_email' => $this->faker->email(),
            'contact_phone' => $this->faker->phoneNumber(),
            'address' => $this->faker->address(),

        ];
    }
}
