package controller;

import model.Empresa;
import model.Funcionario;

import java.time.LocalDate;
import java.util.Comparator;

public class EmpresaFuncionarioController {
    public static void main(String[] args) {
        // --------- d.a ---------
        Empresa empresa1 = new Empresa("23.123.234/0001-34", "Inteligencia Ltda", "Inteligencia Limitada");
        Funcionario funcionario1 = new Funcionario(1L, "245.743.532-43", "Ana", "Silva", LocalDate.of(1999, 4, 24));
        Funcionario funcionario2 = new Funcionario(2L, "234.325.561-23", "Joao", "Santos", LocalDate.of(1995, 1, 2));
        // --------- d.b ---------
        empresa1.getFuncionarioList().add(funcionario1);
        empresa1.getFuncionarioList().add(funcionario2);
        // --------- d.c ---------
        System.out.println("\nLista de Funcionários por Empresa (critério nome)");
        System.out.print("\nEmpresa " + empresa1.getNomeFantasia());
        empresa1.getFuncionarioList().sort(Comparator.comparing(Funcionario::getNome));
        System.out.println(empresa1);







    }
}
