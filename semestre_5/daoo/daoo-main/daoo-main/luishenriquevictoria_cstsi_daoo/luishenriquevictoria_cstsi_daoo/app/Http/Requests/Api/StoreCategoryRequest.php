<?php

namespace App\Http\Requests\Api;

use Illuminate\Foundation\Http\FormRequest;

class StoreCategoryRequest extends FormRequest
{
    public function authorize()
    {
        return true; // Permite que todos os usuários acessem
    }

    public function rules()
    {
        return [
            'name' => 'required|string|max:255',
        ];
    }
}
