package controller;

import model.Automovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class AutomovelController {
    public static void main(String[] args) {
        Automovel carro1 = new Automovel(UUID.randomUUID(), "112139", "IUE2253", "branco", 4, "gasolina", 42432, "ferro", 150.00);
        Automovel carro2 = new Automovel(UUID.randomUUID(), "112139", "ISA1615", "preto", 4, "gasolina", 123432, "ferro", 1550.00);
        Automovel carro3 = new Automovel(UUID.randomUUID(), "123139", "ASB3365", "vermelho", 4, "gasolina", 23432, "ferro", 1002.00);
        Automovel carro4 = new Automovel(UUID.randomUUID(), "123139", "UCB3175", "branco", 4, "gasolina", 11232, "ferro", 10120.00);
        Automovel carro5 = new Automovel(UUID.randomUUID(), "121332", "IUG3165", "branco", 4, "diesel", 11232, "ferro", 13200.00);

        List<Automovel> carros = new ArrayList<>();
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);

        // Ordenar a coleção pelo atributo id do AUTOMOVEL
        System.out.println("-------LISTA DECRESCENTE POR ID--------");
        carros.sort(Comparator.comparing(Automovel::getId).reversed());
        System.out.println(carros);


        // Pesquisando na coleção pelo método filter
        System.out.println("------------ LOCALIZAR AUTOMOVEL POR FILTRO-------------");
        Automovel carrosPesquisa = carros.stream().filter(p -> p.getPlaca().equals("ASB3365")).findAny().orElse(null);
        System.out.println(carrosPesquisa);


    }
}
