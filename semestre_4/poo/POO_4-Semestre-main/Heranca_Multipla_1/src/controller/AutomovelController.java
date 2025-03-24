package controller;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AutomovelController {
    public static void main(String[] args) {
        // Criando objetos iniciais
        Bicicleta bicicleta = new Bicicleta(2, "Manual", "Giant", "Defy", 2023, 28, "BC123456");
        Carro carro = new Carro("111111111", "9BWZZZ377VT004251", "ABC-1234", 2, "Gasolina", "Nissan", "Altima", 2021, 500);
        Caminhao caminhao = new Caminhao("222222222", "1HTMKADN43H561298", "XYZ-9876", 3, "Diesel", "Mack", "Anthem", 2022, 18000);

        System.out.println("\n---- Imprimindo o objeto Bicicleta ----");
        System.out.println(bicicleta.toString());

        System.out.println("\n---- Imprimindo o objeto Carro ----");
        System.out.println(carro.toString());

        System.out.println("\n---- Imprimindo o objeto Caminhão ----");
        System.out.println(caminhao.toString());

        // Criando e adicionando bicicletas à lista
        Bicicleta bicicleta1 = new Bicicleta(1, "Humana", "Giant", "TCR Advanced", 2020, 28, "BIC001");
        Bicicleta bicicleta2 = new Bicicleta(2, "Humana", "Cannondale", "Synapse", 2021, 28, "BIC002");
        Bicicleta bicicleta3 = new Bicicleta(3, "Humana", "Trek", "Emonda", 2019, 28, "BIC003");
        Bicicleta bicicleta4 = new Bicicleta(4, "Humana", "Specialized", "Roubaix", 2020, 28, "BIC004");
        Bicicleta bicicleta5 = new Bicicleta(5, "Humana", "Scott", "Addict", 2021, 28, "BIC005");

        // Criando e adicionando carros à lista
        Carro carro1 = new Carro("333333333", "8AWZZZ377VT004252", "DEF-5678", 2, "Diesel", "BMW", "Series 3", 2019, 450);
        Carro carro2 = new Carro("444444444", "7CWZZZ377VT004253", "GHI-9101", 2, "Gasolina", "Mercedes-Benz", "C-Class", 2020, 480);
        Carro carro3 = new Carro("555555555", "6DWZZZ377VT004254", "JKL-1121", 2, "Flex", "Audi", "A4", 2022, 460);
        Carro carro4 = new Carro("666666666", "5EWZZZ377VT004255", "MNO-3141", 2, "Elétrico", "Tesla", "Model S", 2023, 600);
        Carro carro5 = new Carro("777777777", "4FWZZZ377VT004256", "PQR-5161", 2, "Híbrido", "Toyota", "Prius", 2021, 470);

        // Criando e adicionando caminhões à lista
        Caminhao caminhao1 = new Caminhao("888888888", "3GWZZZ377VT004257", "STU-7181", 4, "Diesel", "Kenworth", "W900", 2020, 20000);
        Caminhao caminhao2 = new Caminhao("999999999", "2HWZZZ377VT004258", "VWX-9201", 4, "Diesel", "Peterbilt", "389", 2018, 22000);
        Caminhao caminhao3 = new Caminhao("101010101", "1IWZZZ377VT004259", "YZA-1221", 4, "Diesel", "Freightliner", "Cascadia", 2021, 25000);
        Caminhao caminhao4 = new Caminhao("202020202", "0JWZZZ377VT004260", "BCD-3241", 4, "Diesel", "International", "LT", 2019, 23000);
        Caminhao caminhao5 = new Caminhao("303030303", "9JWZZZ377VT004261", "EFG-4252", 4, "Diesel", "Western Star", "4900", 2022, 24000);

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(bicicleta1);
        veiculos.add(bicicleta2);
        veiculos.add(bicicleta3);
        veiculos.add(bicicleta4);
        veiculos.add(bicicleta5);
        veiculos.add(carro1);
        veiculos.add(carro2);
        veiculos.add(carro3);
        veiculos.add(carro4);
        veiculos.add(carro5);
        veiculos.add(caminhao1);
        veiculos.add(caminhao2);
        veiculos.add(caminhao3);
        veiculos.add(caminhao4);
        veiculos.add(caminhao5);

        // Ordenando e imprimindo a lista de veículos
        veiculos.sort(Comparator.comparing(Veiculo::getAnoFabricacao).reversed());
        System.out.println("\n---- Lista de todos os veículos (Ordem Decrescente por Ano de Fabricação) ----");
        veiculos.forEach(System.out::println);

        // Imprimindo apenas automóveis
        System.out.println("\n---- Lista de Automóveis ----");
        veiculos.forEach(v -> {
            if(v instanceof Automovel) {
                System.out.println(v);
            }
        });

        // Imprimindo apenas bicicletas
        System.out.println("\n---- Lista de Bicicletas ----");
        veiculos.forEach(v -> {
            if(v instanceof Bicicleta) {
                System.out.println(v);
            }
        });

        // Ordenando e imprimindo automóveis com placa começando com "I" ou "i"
        veiculos.sort(Comparator.comparing(Veiculo::getAnoFabricacao));
        System.out.println("\n---- Lista de Automóveis com Placa Iniciando com 'I' ou 'i' ----");
        veiculos.forEach(v -> {
            if(v instanceof Automovel) {
                if( ((Automovel) v).getPlaca().startsWith("I") || ((Automovel) v).getPlaca().startsWith("i") ) {
                    System.out.println(v);
                }
            }
        });
    }
}
