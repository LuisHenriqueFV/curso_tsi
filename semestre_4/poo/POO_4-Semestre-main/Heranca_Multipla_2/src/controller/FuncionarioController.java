package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FuncionarioController {
    public static void main(String[] args) {

        // ---- questão 1 ----
        Desenvolvedor desenvolvedor1 = new Desenvolvedor("Alice", 3000);
        Desenvolvedor desenvolvedor2 = new Desenvolvedor("Bruno", 3200);
        Desenvolvedor desenvolvedor3 = new Desenvolvedor("Carla", 3100);
        Desenvolvedor desenvolvedor4 = new Desenvolvedor("Daniel", 3300);
        Desenvolvedor desenvolvedor5 = new Desenvolvedor("Elena", 2900);
        Desenvolvedor desenvolvedor6 = new Desenvolvedor("Fernando", 3400);

        Gerente gerente1 = new Gerente("Giovana Alves", 9500.00, "TSLA", 180);
        Gerente gerente2 = new Gerente("Henrique Lima", 10200.00, "AAPL", 210);
        Gerente gerente3 = new Gerente("Isabel Rocha", 8800.00, "GOOGL", 200);
        Gerente gerente4 = new Gerente("Júlio Mendes", 11200.00, "AMZN", 230);
        Gerente gerente5 = new Gerente("Karina Souza", 9800.00, "MSFT", 190);
        Gerente gerente6 = new Gerente("Lucas Andrade", 10300.00, "NFLX", 220);

        Cliente cliente1 = new Cliente("Marcos", "Oliveira", "AAPL", 60);
        Cliente cliente2 = new Cliente("Nina", "Santos", "GOOGL", 40);
        Cliente cliente3 = new Cliente("Otávio", "Moura", "AMZN", 55);
        Cliente cliente4 = new Cliente("Paula", "Ribeiro", "MSFT", 25);
        Cliente cliente5 = new Cliente("Quintino", "Ferreira", "NFLX", 70);
        Cliente cliente6 = new Cliente("Renata", "Barros", "TSLA", 35);

        System.out.println("\n---- Desenvolvedores ----");
        System.out.println(desenvolvedor1);
        System.out.println(desenvolvedor2);
        System.out.println(desenvolvedor3);
        System.out.println(desenvolvedor4);
        System.out.println(desenvolvedor5);
        System.out.println(desenvolvedor6);

        System.out.println("\n---- Gerentes ----");
        System.out.println(gerente1);
        System.out.println(gerente2);
        System.out.println(gerente3);
        System.out.println(gerente4);
        System.out.println(gerente5);
        System.out.println(gerente6);

        System.out.println("\n---- Clientes ----");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);
        System.out.println(cliente5);
        System.out.println(cliente6);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(desenvolvedor1);
        funcionarios.add(desenvolvedor2);
        funcionarios.add(desenvolvedor3);
        funcionarios.add(desenvolvedor4);
        funcionarios.add(desenvolvedor5);
        funcionarios.add(desenvolvedor6);
        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(gerente3);
        funcionarios.add(gerente4);
        funcionarios.add(gerente5);
        funcionarios.add(gerente6);

        List<Investidor> investidores = new ArrayList<>();
        investidores.add(cliente1);
        investidores.add(cliente2);
        investidores.add(cliente3);
        investidores.add(cliente4);
        investidores.add(cliente5);
        investidores.add(cliente6);
        investidores.add(gerente1);
        investidores.add(gerente2);
        investidores.add(gerente3);
        investidores.add(gerente4);
        investidores.add(gerente5);
        investidores.add(gerente6);

        System.out.println("\n---- Funcionários (ordem decrescente por salário) ----");
        funcionarios.sort(Comparator.comparing(Funcionario::getSalario).reversed());
        funcionarios.forEach(System.out::println);

        System.out.println("\n---- Investidores (ordem decrescente por quantidade de ações) ----");
        investidores.sort(Comparator.comparing(Investidor::getQuantidade).reversed());
        investidores.forEach(System.out::println);

        System.out.println("\n---- Funcionário com o maior salário ----");
        Funcionario funcMaiorSalario = Collections.max(funcionarios, Comparator.comparing(Funcionario::getSalario));
        funcionarios.stream()
                .filter(f -> f.getSalario() >= funcMaiorSalario.getSalario())
                .forEach(System.out::println);

        System.out.println("\n---- Investidor com a maior quantidade de ações ----");
        Investidor invesMaiorQuantAcoes = Collections.max(investidores, Comparator.comparing(Investidor::getQuantidade));
        investidores.stream()
                .filter(i -> i.getQuantidade() >= invesMaiorQuantAcoes.getQuantidade())
                .forEach(System.out::println);
    }
}
