<?php


// app/Models/Item.php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Item extends Model
{
    use HasFactory;

    // Definindo os campos preenchíveis
    protected $fillable = [
        'name',
        'description',
        'status',
        'category_id',
        'user_id',
        'date',
        'contact_email',
        'contact_phone',
        'address',
    ];

    // Relacionamento com a categoria
    public function category()
    {
        return $this->belongsTo(Category::class);
    }

    // Relacionamento com o usuário
    public function user()
    {
        return $this->belongsTo(User::class);
    }
}
