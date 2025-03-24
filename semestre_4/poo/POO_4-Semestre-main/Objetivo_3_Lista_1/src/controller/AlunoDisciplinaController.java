package controller;

import model.Aluno;
import model.Disciplina;

import java.util.Comparator;

public class AlunoDisciplinaController {
    public static void main(String[] args) {
        // --------- c.a ----------
        Aluno aluno1 = new Aluno(1L, "Luis", "Fonseca");
        Aluno aluno2 = new Aluno(2L, "Gabriel", "Cardoso");

        Disciplina disciplina1 = new Disciplina(1L, "LPOO");
        Disciplina disciplina2 = new Disciplina(2L, "ED");

        // --------- c.b ---------
        aluno1.getDisciplinaList().add(disciplina1);
        aluno1.getDisciplinaList().add(disciplina2);
        aluno2.getDisciplinaList().add(disciplina1);
        aluno2.getDisciplinaList().add(disciplina2);

        // --------- c.c ---------
        System.out.println("\nRelatório de Disciplinas por Aluno\n");
        aluno1.getDisciplinaList().sort(Comparator.comparing(Disciplina::getNome));
        System.out.println("Aluno: " + aluno1.getNome());
        System.out.println(aluno1.getDisciplinaList());
        System.out.println("---------------------------");
        aluno2.getDisciplinaList().sort(Comparator.comparing(Disciplina::getNome));
        System.out.println("Aluno: " + aluno2.getNome());
        System.out.println(aluno2.getDisciplinaList());

    }
}
