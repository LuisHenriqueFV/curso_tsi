<?php

namespace App\classes;

abstract class Pessoa
{
    protected $nome;

    public function __construct($nome)
    {
        $this->nome = $nome;
    }

    public function getNome(): string
    {
        return $this->nome;
    }
}
