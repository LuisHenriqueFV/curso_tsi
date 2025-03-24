package controller;

import model.Funcionario;
import model.Gerente;

public class GerenteController {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente("Luis", 1000.00);
        Gerente gerente2 = new Gerente();


        System.out.println("-----SALARIO INICIAL----");
        System.out.println(gerente1);
        System.out.println(gerente2);

        System.out.println("-----SALARIOS ALTERADOS----");
        gerente1.setSalario(1000.00);
        System.out.println(gerente1);
        gerente2.setSalario(5000.00);
        System.out.println(gerente2);

        System.out.println("-----BONUS GERENTE----");
        System.out.println(gerente1.getBonus());
        System.out.println(gerente2.getBonus());

        //1) Foi possível criar instâncias da classe Funcionario? Justifique sua resposta.
        //Não foi possível pois a classe Funcionario foi definida como abstract, ou seja,  não é possível criar uma nova instância diretamente dessa classe.
        //Uma classe abstrata é uma classe que não pode ser instanciada, mas pode ser usada como base para outras classes.
        //Ela geralmente contém métodos abstratos, que são métodos sem implementação, e esses métodos devem ser implementados nas classes derivadas.

        //2) Onde você deve inserir estas regras de negócio? Na classe xxController ou nas
        //classes Gerente e Desenvolvedor? Justifique sua resposta.
        //as regras de negocio para especificadas para o gerente serão implementadas na classe Gerente.
        //as regras de negocio para especificadas para o desenvolvedor serão implementadas na classe Desenvolvedor.



    }
}
