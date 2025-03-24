package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    public static void main(String[] args) {
        Gerente gerente1 = new GerenteGeral("Luis", 6500.00 );
        Gerente gerente2 = new GerenteDesenvolvedores("Henrique", 4500.00);
        Desenvolvedor dev1 = new DesenvolvedorSenior("Carlos", 3500.00);
        Desenvolvedor dev2 = new DesenvolvedorSenior("Jorival", 3500.00);
        Desenvolvedor dev3 = new DesenvolvedorSenior("Claudiane", 3500.00);
        Desenvolvedor dev4 = new DesenvolvedorSenior("Amolis", 3500.00);
        Desenvolvedor dev5 = new DesenvolvedorSenior("Kity", 3500.00);
        Desenvolvedor dev6 = new DesenvolvedorSenior("Honey", 3500.00);

        Desenvolvedor dev7 = new DesenvolvedorJunior("Lucas", 1800.00);
        Desenvolvedor dev8 = new DesenvolvedorJunior("Gus", 1800.00);
        Desenvolvedor dev9 = new DesenvolvedorJunior("Felipe", 1800.00);
        Desenvolvedor dev10 = new DesenvolvedorJunior("Yngrid", 1800.00);
        Desenvolvedor dev11 = new DesenvolvedorJunior("Duda", 1800.00);
        Desenvolvedor dev12 = new DesenvolvedorJunior("Bianca", 1800.00);

        Desenvolvedor dev13 = new DesenvolvedorPleno("Patricio", 2500.00);
        Desenvolvedor dev14 = new DesenvolvedorPleno("Solto", 2500.00);
        Desenvolvedor dev15 = new DesenvolvedorPleno("Sara", 2500.00);
        Desenvolvedor dev16 = new DesenvolvedorPleno("Juriscleide", 2500.00);
        Desenvolvedor dev17 = new DesenvolvedorPleno("Cacau", 2500.00);
        Desenvolvedor dev18 = new DesenvolvedorPleno("Chocolate", 2500.00);


        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(dev1);
        funcionarios.add(dev2);
        funcionarios.add(dev3);
        funcionarios.add(dev4);
        funcionarios.add(dev5);
        funcionarios.add(dev6);
        funcionarios.add(dev7);
        funcionarios.add(dev8);
        funcionarios.add(dev9);
        funcionarios.add(dev10);
        funcionarios.add(dev11);
        funcionarios.add(dev12);
        funcionarios.add(dev13);
        funcionarios.add(dev14);
        funcionarios.add(dev15);
        funcionarios.add(dev16);
        funcionarios.add(dev17);
        funcionarios.add(dev18);

        double folha_com_bonus = 0.0;
                for (Funcionario funcionario : funcionarios){
                    folha_com_bonus += funcionario.getSalario() + funcionario.getBonus();
                }



    }
}
