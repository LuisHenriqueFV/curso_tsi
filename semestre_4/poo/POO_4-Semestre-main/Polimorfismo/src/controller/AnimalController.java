package controller;

import model.Animal;
import model.Cachorro;
import model.Passaro;
import model.Peixe;

import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    public static void main(String[] args) {
        Cachorro cachorro1 = new Cachorro(1.0, 3.0);
        Cachorro cachorro2 = new Cachorro(2.0, 4.0);
        Cachorro cachorro3 = new Cachorro(3.0, 5.0);

        Passaro passaro1 = new Passaro(1.0, 3.0);
        Passaro passaro2 = new Passaro(2.0, 4.0, 3.2);
        Passaro passaro3 = new Passaro(3.0, 5.0);

        Peixe peixe1 = new Peixe(1.0, 3.0, 7.0);
        Peixe peixe2 = new Peixe(2.0, 4.0, 7.0);
        Peixe peixe3 = new Peixe(3.0, 7.0);

        List<Animal> animais = new ArrayList<>();
        animais.add(cachorro1);
        animais.add(cachorro2);
        animais.add(cachorro3);
        animais.add(passaro1);
        animais.add(passaro2);
        animais.add(passaro3);
        animais.add(peixe1);
        animais.add(peixe2);
        animais.add(peixe3);

        System.out.println("---- Animais ----");
        animais.forEach(System.out::println);

        System.out.println("\n---- Movendo todos os animais ----");
        animais.forEach(animal -> {
            animal.mover(2.0, 2.0);
            animal.desenhar();
            System.out.println(animal);
        });

        System.out.println("\n---- Movendo apenas os cachorros ----");
        animais.forEach(animal -> {
            if (animal instanceof Cachorro) {
                animal.mover(8.0, 8.0);
                animal.desenhar();
                System.out.println(animal);
            }
        });

        System.out.println("\n---- Movendo peixes e pássaros com coordenação ----");
        animais.forEach(animal -> {
            if (animal instanceof Peixe) {
                ((Peixe) animal).mover(5.0, 5.0, 5.0);
                animal.desenhar();
                System.out.println(animal);
            } else if (animal instanceof Passaro) {
                ((Passaro) animal).mover(5.0, 5.0, 5.0);
                animal.desenhar();
                System.out.println(animal);
            }
        });
    }
}
