<?php

namespace App\classes;

use App\interfaces\iFuncionario;

class Atleta extends Pessoa implements iFuncionario
{
    private $peso;
    private $altura;
    private $salario;
    private $tempoContrato;

    public function __construct($nome, $altura, $peso, $salario = 45000, $tempoContrato = 4)
    {
        parent::__construct($nome);
        $this->altura = $altura;
        $this->peso = $peso;
        $this->salario = $salario;
        $this->tempoContrato = $tempoContrato;
    }

    public function getPeso(): float
    {
        return $this->peso;
    }

    public function getAltura(): float
    {
        return $this->altura;
    }

    public function mostrarSalario(): string
    {
        return "Salário: R$ " . number_format($this->salario, 2, ',', '.');
    }

    public function mostrarTempoContrato(): string
    {
        return "Contrato de " . $this->tempoContrato . " anos.";
    }
}
