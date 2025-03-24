package Controller;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    public static void main(String[] args) {
        //a. Crie 3 instâncias de cada classe (das possíveis de criar instâncias), insira valores válidos nos atributos dessas instâncias, e imprima esses objetos;
        Cliente cliente1 = new Cliente("Carla");
        Cliente cliente2 = new Cliente("José");
        Cliente cliente3 = new Cliente("Maria");

        System.out.println(cliente1.getNome());
        System.out.println(cliente2.getNome());
        System.out.println(cliente3.getNome());

        //b. Crie as coleções necessárias para expressar as contas registradas no sistema, bem como, os associados, depois, imprima essa(s) coleção(ões);
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        System.out.println(clienteList);
    }
}
