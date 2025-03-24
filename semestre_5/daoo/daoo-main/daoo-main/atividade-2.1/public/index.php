<?php

require_once __DIR__ . '/../vendor/autoload.php';

use App\Classes\Atleta;

$atleta = new Atleta("João", 25, 40, 1.75);
$atleta->calcIMC();

echo "Nome: " . $atleta->getNome() . PHP_EOL;
echo "IMC: " . number_format($atleta->getIMC(), 2) . PHP_EOL;
echo "Classificação: " . $atleta->classifica() . PHP_EOL;
echo "IMC normal? " . ($atleta->isNormal() ? "Sim" : "Não") . PHP_EOL;
