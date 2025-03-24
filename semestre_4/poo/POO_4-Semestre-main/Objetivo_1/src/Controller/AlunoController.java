package Controller;

import Model.*;

import java.util.*;

public class AlunoController {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(); //construtor padrão
        Aluno aluno2 = new Aluno(); //construtor padrão
        Aluno aluno3 = new Aluno(3, 324345642, "Diogo", "Fonseca", "diogo@email.com" ); //construtor parametrizado com todos os atributos
        Aluno aluno4 = new Aluno(4, 232455123, "Tiago", "Petry", "tiago@email.com" ); //construtor parametrizado com todos os atributos
        Aluno aluno5 = new Aluno(5, "Rafael"); //construtor parametrizado com apenas dois atributos
        Aluno aluno6 = new Aluno(6, "Emanuel"); //construtor parametrizado com apenas dois atributos

        //1.a
        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(aluno3);
        System.out.println(aluno4);
        System.out.println(aluno5);
        System.out.println(aluno6);
        //1.b
        aluno1.setId(1);
        aluno1.setCpf(35123);
        aluno1.setNome("Carlos");
        aluno1.setSobrenome("Nobre");
        aluno1.setEmail("carlos@email.com");

        aluno2.setId(2);
        aluno2.setCpf(354233);
        aluno2.setNome("Joao");
        aluno2.setSobrenome("Silva");
        aluno2.setEmail("joao@email.com");

        //Imprimir os atributos das instâncias modificadas usando getters
        System.out.println("Aluno1 \nID: " + aluno1.getId() + "\n" + "CPF: " + aluno1.getCpf() +"\n"+ "NOME: " + aluno1.getNome()+"\n" + "SOBRENOME: " + aluno1.getSobrenome()+"\n" + "E-MAIL: " + aluno1.getEmail());
        System.out.println("-----------------------------------");
        System.out.println("Aluno2 \nID: " + aluno2.getId() + "\n" + "CPF: " + aluno2.getCpf() +"\n"+ "NOME: " + aluno2.getNome()+"\n" + "SOBRENOME: " + aluno2.getSobrenome()+"\n" + "E-MAIL: " + aluno2.getEmail());

        //2
        //Criação de tipos de coleções de objetos
        List<Aluno> alunoList = new ArrayList<>();
        Map<Integer, Aluno> alunoMap = new TreeMap<>(); //TreeMap serve para dar ordenação na chave 'id'

        //Adicionar objetos a coleção List
        alunoList.add(aluno1);
        alunoList.add(aluno2);
        alunoList.add(aluno3);
        alunoList.add(aluno4);
        alunoList.add(aluno5);
        alunoList.add(aluno6);

        //Adicionar objetos a coleção Map
        alunoMap.put(aluno1.getId(), aluno1);
        alunoMap.put(aluno2.getId(), aluno2);
        alunoMap.put(aluno3.getId(), aluno3);
        alunoMap.put(aluno4.getId(), aluno4);
        alunoMap.put(aluno5.getId(), aluno5);
        alunoMap.put(aluno6.getId(), aluno6);

        //Imprimir objetos da coleção List
        System.out.println("\nLista de alunos:");
        for (Aluno aluno : alunoList) {
            System.out.println(aluno);
        }

        // Imprimindo objetos Aluno ordenados por id (ordem crescente)
        System.out.println("\nMapa de alunos:");
        for (Map.Entry<Integer, Aluno> entry : alunoMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        // Imprimir o objeto de id=5 de cada coleção
        System.out.println("\nObjeto de id=5 na List:");
        for (Aluno aluno : alunoList) {
            if (aluno.getId() == 5) {
                System.out.println(aluno);
            }
        }
        System.out.println("\nObjeto de id=5 no Map:");
        if (alunoMap.containsKey(5)) {
            System.out.println(alunoMap.get(5));
        }
        // Ordenar e imprimir a coleção List em ordem decrescente pelo campo id
        System.out.println("\nLista de alunos (ordem decrescente):");
        alunoList.sort(Comparator.comparing(Aluno::getId).reversed());
        for (Aluno aluno : alunoList) {
            System.out.println(aluno);
        }
        // Ordenar e imprimir a coleção Map em ordem decrescente pelo campo id
        System.out.println("\nMapa de alunos (ordem decrescente):");
        Map<Integer, Aluno> alunoMapDesc = new TreeMap<>(Collections.reverseOrder());
        alunoMapDesc.putAll(alunoMap);
        for (Map.Entry<Integer, Aluno> entry : alunoMapDesc.entrySet()) {
            System.out.println(entry.getValue());

        }



    }
}
