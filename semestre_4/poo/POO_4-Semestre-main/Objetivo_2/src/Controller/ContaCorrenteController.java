package Controller;

import Model.Conta;
import Model.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteController {
    public static void main(String[] args) {
        // a. Crie 3 instâncias de cada classe (das possíveis de criar instâncias), insira valores válidos nos atributos dessas instâncias, e imprima esses objetos;
        ContaCorrente contaCorrente1 = new ContaCorrente(4000);
        ContaCorrente contaCorrente2 = new ContaCorrente(5000);
        ContaCorrente contaCorrente3 = new ContaCorrente(6000);

        System.out.println("Saldo Conta Corrente 1: " + contaCorrente1.getSaldo());
        System.out.println("Saldo Conta Corrente 2: " + contaCorrente2.getSaldo());
        System.out.println("Saldo Conta Corrente 3: " + contaCorrente3.getSaldo());

        // b. Crie as coleções necessárias para expressar as contas registradas no sistema, bem como, os associados, depois, imprima essa(s) coleção(ões);
        List<Conta> contaList = new ArrayList<>();
        contaList.add(contaCorrente1);
        contaList.add(contaCorrente2);
        contaList.add(contaCorrente3);

        // Imprimindo a lista de contas
        System.out.println("Lista de Contas Correntes:");
        for (Conta conta : contaList) {
            System.out.println(conta);
        }
        //Movimente, pelo menos, uma conta corrente, realizando as seguintes operações: depósito R$ 500,00; saque de R$ 400,00;
        contaCorrente1.deposita(500);
        contaCorrente1.saca(400);
        System.out.println(contaCorrente1.getSaldo());

    }
}
