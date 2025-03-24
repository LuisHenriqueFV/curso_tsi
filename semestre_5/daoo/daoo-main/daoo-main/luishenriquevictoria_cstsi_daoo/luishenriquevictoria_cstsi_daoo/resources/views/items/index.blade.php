@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Lista de Itens</h1>

    <!-- Botões adicionais para administradores -->
    @auth
    @if (Auth::user()->is_admin)
    <div class="mb-3">
        <a href="{{ route('categories.index') }}" class="btn btn-success">Gerenciar Categorias</a>
        <a href="{{ route('users.index') }}" class="btn btn-info">Gerenciar Usuários</a>
    </div>
    @endif
    @endauth

    <!-- Botão para adicionar novo item (visível apenas para usuários autenticados) -->
    @auth
    <a href="{{ route('items.create') }}" class="btn btn-primary mb-3">Adicionar Novo Item</a>
    @endauth

    <!-- Formulário de Filtro -->
    <form method="GET" action="{{ route('items.index') }}" class="mb-3">
        <div class="row">
            <div class="col-md-3">
                <input
                    type="text"
                    name="name"
                    class="form-control"
                    placeholder="Buscar por nome"
                    value="{{ request('name') }}">
            </div>
            <div class="col-md-3">
                <select
                    name="category_id"
                    class="form-control"
                    aria-label="Selecione a Categoria">
                    <option value="">Selecionar Categoria</option>
                    @foreach ($categories as $category)
                    <option value="{{ $category->id }}" {{ request('category_id') == $category->id ? 'selected' : '' }}>
                        {{ $category->name }}
                    </option>
                    @endforeach
                </select>
            </div>
            <div class="col-md-3">
                <select
                    name="status"
                    class="form-control"
                    aria-label="Selecione o Status">
                    <option value="">Selecionar Status</option>
                    <option value="perdido" {{ request('status') == 'perdido' ? 'selected' : '' }}>Perdido</option>
                    <option value="achado" {{ request('status') == 'achado' ? 'selected' : '' }}>Achado</option>
                </select>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary">Filtrar</button>
                <a href="{{ route('items.index') }}" class="btn btn-secondary">Limpar</a>
            </div>
        </div>
    </form>

    <!-- Exibição das contagens por status (agregação) -->
    <div class="mb-3">
        <h4>Contagem de Itens por Status</h4>
        <div class="row">
            <div class="col-md-6 col-lg-4">
                <div class="card text-white bg-info mb-3">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Perdido</h5>
                    </div>
                    <div class="card-body">
                        <h2 class="card-text">{{ $itemCountByStatus['perdido'] ?? 0 }}</h2>
                        <p class="card-text">Itens registrados como Perdido</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4">
                <div class="card text-white bg-success mb-3">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Achado</h5>
                    </div>
                    <div class="card-body">
                        <h2 class="card-text">{{ $itemCountByStatus['achado'] ?? 0 }}</h2>
                        <p class="card-text">Itens registrados como Achado</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Tabela de Itens -->
    <table class="table table-striped">
        <thead>
            <tr>
                @auth
                @if(Auth::user()->is_admin)
                <th>ID</th> <!-- Exibir ID apenas para admin -->
                @endif
                @endauth
                <th>Nome</th>
                <th>Categoria</th>
                <th>Status</th>
                <th>Data</th>
                <th>Endereço</th>
                <th>Email de Contato</th>
                <th>Telefone de Contato</th>
                @auth
                <!-- <th>Ações</th> -->
                @endauth
            </tr>
        </thead>
        <tbody>
            @foreach($items as $item)
            <tr>
                @auth
                @if(Auth::user()->is_admin)
                <td>{{ $item->id }}</td> <!-- Exibe o ID apenas para admin -->
                @endif
                @endauth
                <td>{{ $item->name }}</td>
                <td>{{ $item->category->name }}</td>
                <td>{{ $item->status }}</td>
                <td>{{ $item->date }}</td>
                <td>{{ $item->address ?? 'Não informado' }}</td>
                <td>{{ $item->contact_email ?? 'Não informado' }}</td>
                <td>{{ $item->contact_phone ?? 'Não informado' }}</td>
                <td>
                    @auth
                    @if ($item->user_id === Auth::id() || Auth::user()->is_admin)
                    <a href="{{ route('items.edit', $item->id) }}" class="btn btn-warning btn-sm">Editar</a>

                    <form action="{{ route('items.destroy', $item->id) }}" method="POST" style="display:inline;" onsubmit="return confirmDelete();">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
                    </form>
                    @endif
                    @endauth

                    <script>
                        function confirmDelete() {
                            // Exibe uma caixa de confirmação
                            return confirm('Tem certeza de que deseja excluir este item?');
                        }
                    </script>
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>

    <!-- Paginação -->
    {{ $items->appends(request()->query())->links() }}
</div>
@endsection