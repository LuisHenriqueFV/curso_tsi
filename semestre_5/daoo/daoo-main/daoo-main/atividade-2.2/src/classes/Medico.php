<?php

namespace App\classes;

use App\interfaces\iFuncionario;

class Medico extends Pessoa implements iFuncionario
{
    private $especialidade;
    private $crm;
    private $idade;
    private $salario;
    private $tempoContrato;

    public function __construct($nome, $crm, $especialidade, $idade, $salario = 60000, $tempoContrato = 5)
    {
        parent::__construct($nome);
        $this->crm = $crm;
        $this->especialidade = $especialidade;
        $this->idade = $idade;
        $this->salario = $salario;
        $this->tempoContrato = $tempoContrato;
    }

    public function getEspecialidade(): string
    {
        return $this->especialidade;
    }

    public function getCrm(): int
    {
        return $this->crm;
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
