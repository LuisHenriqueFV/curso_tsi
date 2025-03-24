@extends('layouts.app')

@section('content')
<div class="container">
    <h1>Editar Item</h1>

    <form action="{{ route('items.update', $item->id) }}" method="POST">
        @csrf
        @method('PUT')

        <div class="form-group">
            <label for="name">Nome do Item</label>
            <input type="text" name="name" id="name" class="form-control" value="{{ old('name', $item->name) }}" required>
            @error('name')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>

        <div class="form-group">
            <label for="category_id">Categoria</label>
            <select name="category_id" id="category_id" class="form-control" required>
                @foreach ($categories as $category)
                <option value="{{ $category->id }}" {{ $category->id == $item->category_id ? 'selected' : '' }}>
                    {{ $category->name }}
                </option>
                @endforeach
            </select>
            @error('category_id')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>

        <div class="form-group">
            <label for="description">Descrição</label>
            <textarea name="description" id="description" class="form-control" required>{{ old('description', $item->description) }}</textarea>
            @error('description')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <select name="status" id="status" class="form-control" required>
                <option value="achado" {{ $item->status == 'achado' ? 'selected' : '' }}>Achado</option>
                <option value="perdido" {{ $item->status == 'perdido' ? 'selected' : '' }}>Perdido</option>
            </select>
            @error('status')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>
        <div class="form-group">
            <label for="contact_email">E-mail de Contato</label>
            <input type="email" name="contact_email" id="contact_email" class="form-control"
                value="{{ old('contact_email', $item->contact_email) }}">
            @error('contact_email')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>

        <div class="form-group">
            <label for="contact_phone">Telefone de Contato</label>
            <input type="text" name="contact_phone" id="contact_phone" class="form-control"
                value="{{ old('contact_phone', $item->contact_phone) }}">
            @error('contact_phone')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>
        <label for="address">Localização do Item Perdido/Encontrado</label>
        <input type="text" name="address" value="{{ old('address', $item->address) }}" class="form-control" id="address">

        <div class="form-group">
            <label for="date">Data</label>
            <input type="date" name="date" id="date" class="form-control" value="{{ old('date', $item->date) }}" required>
            @error('date')
            <div class="text-danger">{{ $message }}</div>
            @enderror
        </div>



        <button type="submit" class="btn btn-success mt-3">Salvar Alterações</button>
        <a href="{{ route('items.index') }}" class="btn btn-secondary mt-3">Cancelar</a>
    </form>
</div>
@endsection