{{-- resources/views/categories/create.blade.php --}}
@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Adicionar Nova Categoria</h1>

    <form action="{{ route('categories.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="name">Nome da Categoria</label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Nome da Categoria" required>
        </div>
        <button type="submit" class="btn btn-success mt-3">Salvar Categoria</button>
    </form>
</div>
@endsection