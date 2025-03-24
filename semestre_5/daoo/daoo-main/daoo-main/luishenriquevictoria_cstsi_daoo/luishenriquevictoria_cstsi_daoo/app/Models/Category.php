<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Category extends Model
{
    use HasFactory;

    // Definir os campos que podem ser preenchidos em massa
    protected $fillable = ['name'];

    // Relacionamento com o modelo Item
    public function items()
    {
        return $this->hasMany(Item::class);
    }
}
