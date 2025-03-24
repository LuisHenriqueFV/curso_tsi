<?php

namespace App\Http\Requests\Api;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Support\Facades\Auth;

class UpdateCategoryRequest extends FormRequest
{
    public function authorize()
    {
        return Auth::user() && Auth::user()->is_admin;
    }

    public function rules()
    {
        return [
            'name' => 'required|string|max:255',
        ];
    }
}
