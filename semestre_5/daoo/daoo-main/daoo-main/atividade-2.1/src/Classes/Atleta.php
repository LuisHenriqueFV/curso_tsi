<?php

namespace App\Classes;

use App\Traits\IMC;

class Atleta
{
    use IMC;

    private string $nome;
    private int $idade;
    private float $peso;
    private float $altura;
    private ?float $imc = null;

    public function __construct(string $nome, int $idade, float $peso, float $altura)
    {
        $this->nome = $nome;
        $this->idade = $idade;
        $this->peso = $peso;
        $this->altura = $altura;
    }

    public function getIMC(): ?float
    {
        return $this->imc;
    }

    public function getNome(): string
    {
        return $this->nome;
    }
}
