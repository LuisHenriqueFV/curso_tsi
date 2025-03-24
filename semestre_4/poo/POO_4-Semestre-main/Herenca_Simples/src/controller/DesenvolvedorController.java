package controller;

import model.Desenvolvedor;

public class DesenvolvedorController{
    public static void main(String[] args) {


        Desenvolvedor desenvolvedor1 = new Desenvolvedor();
        Desenvolvedor desenvolvedor2 = new Desenvolvedor("Vitoria", 2000.00);

        System.out.println(desenvolvedor1);
        System.out.println(desenvolvedor2);
        System.out.println(desenvolvedor2.getBonus());

    }

}
