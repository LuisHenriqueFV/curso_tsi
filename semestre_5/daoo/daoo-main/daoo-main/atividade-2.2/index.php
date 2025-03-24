<?php
require 'vendor/autoload.php';

use App\classes\Atleta;
use App\classes\Medico;

use App\logs\Relatorio;

// Criando objetos
$medico = new Medico("Luis", 12345, "Fisiologista", 65);
$atleta = new Atleta("Henrique", 1.9, 84);

// Criando o relatório
$relatorio = new Relatorio();
$relatorio->add($medico);
$relatorio->add($atleta);
$relatorio->imprime();
