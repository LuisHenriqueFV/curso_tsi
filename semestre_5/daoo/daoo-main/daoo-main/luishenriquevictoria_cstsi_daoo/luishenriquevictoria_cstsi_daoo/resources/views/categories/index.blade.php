@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Categorias</h1>

    <!-- Botão para adicionar nova categoria -->
    <a href="{{ route('categories.create') }}" class="btn btn-primary mb-3">Adicionar Nova Categoria</a>

    <!-- Formulário de Filtro -->
    <form method="GET" action="{{ route('categories.index') }}" class="mb-3">
        <div class="row">
            <div class="col-md-4">
                <input
                    type="text"
                    name="name"
                    class="form-control"
                    placeholder="Buscar por nome"
                    value="{{ request('name') }}">
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary">Filtrar</button>
                <a href="{{ route('categories.index') }}" class="btn btn-secondary">Limpar</a>
            </div>
        </div>
    </form>

    <!-- Tabela de Categorias -->
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            @forelse ($categories as $category)
            <tr>
                <td>{{ $category->id }}</td>
                <td>{{ $category->name }}</td>
                <td>
                    <a href="{{ route('categories.edit', $category->id) }}" class="btn btn-warning btn-sm">Editar</a>
                    <form action="{{ route('categories.destroy', $category->id) }}" method="POST" style="display:inline;">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
                    </form>
                </td>
            </tr>
            @empty
            <tr>
                <td colspan="3" class="text-center">Nenhuma categoria encontrada.</td>
            </tr>
            @endforelse
        </tbody>
    </table>

    <!-- Paginação -->
    {{ $categories->appends(request()->query())->links() }}
</div>
@endsection