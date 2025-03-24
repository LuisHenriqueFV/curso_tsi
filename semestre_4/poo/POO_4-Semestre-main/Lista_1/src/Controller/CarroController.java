package controller;

import model.Carro;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarroController {
    public static void main(String[] args) {
        Carro carro1 = new Carro("hyundai", "sedan");
        Carro carro2 = new Carro("fiat", "hatch");
        Carro carro3 = new Carro("chevrollet", "sedan");
        Carro carro4 = new Carro("ford", "sedan");
        Carro carro5 = new Carro("toyata", "sedan");

        List<Carro>carros = new ArrayList<>();
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);
        System.out.println(carros);
    }
}
