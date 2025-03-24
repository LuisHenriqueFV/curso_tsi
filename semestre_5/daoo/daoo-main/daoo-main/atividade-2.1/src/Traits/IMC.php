<?php

namespace App\Traits;

trait IMC
{
    public function calcIMC(): void
    {
        // Calcula o IMC: peso (kg) / altura (m)^2
        $this->imc = $this->peso / ($this->altura ** 2);
    }

    public function classifica(): string
    {
        // Classificação do IMC
        if ($this->imc < 18.5) {
            return "Abaixo do peso";
        } elseif ($this->imc >= 18.5 && $this->imc < 25) {
            return "Peso normal";
        } elseif ($this->imc >= 25 && $this->imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    public function isNormal(): bool
    {
        // Determina se o IMC está normal considerando a idade
        return $this->imc >= 18.5 && $this->imc < 25;
    }
}
