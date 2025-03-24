@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Adicionar Novo Item</h1>

    <form action="{{ route('items.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="name">Nome do Item</label>
            <input type="text" name="name" id="name" class="form-control" placeholder="Nome do Item" required>
        </div>
        <div class="form-group">
            <label for="category_id">Categoria</label>
            <select name="category_id" id="category_id" class="form-control" required>
                @foreach ($categories as $category)
                <option value="{{ $category->id }}">{{ $category->name }}</option>
                @endforeach
            </select>
        </div>
        <div class="form-group">
            <label for="description">Descrição</label>
            <textarea name="description" id="description" class="form-control" placeholder="Descrição do Item" required></textarea>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <select name="status" id="status" class="form-control" required>
                <option value="perdido">Perdido</option>
                <option value="achado">Achado</option>
            </select>
        </div>
        <div class="form-group">
            <label for="date">Data</label>
            <input type="date" name="date" id="date" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="contact_email">E-mail de Contato</label>
            <input type="email" name="contact_email" id="contact_email" class="form-control" placeholder="E-mail de Contato">
        </div>
        <div class="form-group">
            <label for="contact_phone">Telefone de Contato</label>
            <input type="text" name="contact_phone" id="contact_phone" class="form-control" placeholder="Telefone de Contato">
        </div>
        <div class="form-group">
            <label for="address">Localização do Item Perdido/Achado</label>
            <textarea name="address" id="address" class="form-control" rows="2"></textarea>
        </div>

        <button type="submit" class="btn btn-success mt-3">Salvar Item</button>
        <a href="{{ route('items.index') }}" class="btn btn-secondary mt-3">Cancelar</a>

    </form>
</div>
@endsection