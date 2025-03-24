package controller;

import model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioController {
    public static void main(String[] args) {

        // Cada funcionário simula um registro em um banco de dados
        Funcionario funcionario1 = new Funcionario(1L, "Joao", 1200);
        Funcionario funcionario2 = new Funcionario(2L, "Henrique", 6500);
        Funcionario funcionario3 = new Funcionario(3L,"Luis", 4500);
        Funcionario funcionario4 = new Funcionario(4L,"Vitoria", 7000);
        Funcionario funcionario5 = new Funcionario(5L,"Gabriel", 1200);

        // Criando a coleção e adicionando objetos na coleção
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);
        System.out.println("---------LISTA ORIGINAL---------");
        System.out.println(funcionarios);

        // Ordenar a coleção pelo atributo nome do funcionário
        funcionarios.sort(Comparator.comparing(Funcionario::getId).reversed());
        System.out.println("--------LISTA ORDENADA--------");
        System.out.println(funcionarios);

        System.out.println();
        System.out.println("--------- LOCALIZAR FUNCIONÁRIO PELO ID: 3 ---------");

        // Pesquisa por força bruta
        funcionarios.forEach(p -> {
            if(p.getId() ==3L){
                System.out.println(p);
            }
        });

        System.out.println("------------ LOCALIZAR FUNCIONÁRIO POR FILTRO-------------");
        // Pesquisando na coleção pelo método filter
        Funcionario funcionarioFind = funcionarios.stream().filter(p -> p.getId()==1L).findAny().orElse(null);
        System.out.println(funcionarioFind);

    }
}