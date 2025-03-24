<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\User;
use Illuminate\Support\Facades\Hash;

class AdminUserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // Verifique se o usuário admin já existe
        $user = User::where('email', 'admin@example.com')->first();

        if (!$user) {
            // Crie o usuário Admin
            User::create([
                'name' => 'Admin',
                'email' => 'admin@gmail.com',
                'password' => Hash::make('123456'),
                'is_admin' => 1,
            ]);
        }
    }
}
