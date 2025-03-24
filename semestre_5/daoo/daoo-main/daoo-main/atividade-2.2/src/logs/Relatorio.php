<?php

namespace App\logs;

use App\classes\Pessoa;

class Relatorio
{
    private $itens = [];

    public function add(Pessoa $pessoa)
    {
        $this->itens[] = $pessoa;
    }

    public function imprime()
    {
        echo "### RELATORIO ###\n";
        foreach ($this->itens as $item) {
            echo "log:\n";

            if ($item instanceof \App\classes\Medico) {
                echo "===Dados de classes\\Medico===\n";
                echo "Nome: {$item->getNome()}\n";
                echo "Especialidade: {$item->getEspecialidade()}\n";
                echo "CRM: {$item->getCrm()}\n";
            } elseif ($item instanceof \App\classes\Atleta) {
                echo "===Dados do Atleta===\n";
                echo "Nome: {$item->getNome()}\n";
                echo "Peso: {$item->getPeso()}\n";
                echo "Altura: {$item->getAltura()}\n";
            }

            if ($item instanceof \App\interfaces\iFuncionario) {
                echo "Contrato:\n";
                echo $item->mostrarSalario() . "\n";
                echo $item->mostrarTempoContrato() . "\n";
            }

            echo "==================\n";
        }
    }
}
