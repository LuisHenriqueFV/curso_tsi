package Controller;

import Model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupancaController {
    public static void main(String[] args) {
        // Criando instâncias de ContaPoupanca com valores iniciais
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(1000);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(2000);
        ContaPoupanca contaPoupanca3 = new ContaPoupanca(3000);

        // Imprimindo os saldos individuais iniciais
        System.out.println("Saldo Conta Poupança 1: " + contaPoupanca1.getSaldo());
        System.out.println("Saldo Conta Poupança 2: " + contaPoupanca2.getSaldo());
        System.out.println("Saldo Conta Poupança 3: " + contaPoupanca3.getSaldo());

        // Adicionando as instâncias à lista de contas
        List<ContaPoupanca> contaList = new ArrayList<>();
        contaList.add(contaPoupanca1);
        contaList.add(contaPoupanca2);
        contaList.add(contaPoupanca3);

        // Imprimindo a lista de contas
        System.out.println("Lista de Contas:");
        for (ContaPoupanca conta : contaList) {
            System.out.println(conta);
        }

        // Movimentando a conta poupança 1 conforme especificado
        System.out.println("\nRealizando movimentação na Conta Poupança 1:");
        contaPoupanca1.deposita(1000);  // Depósito de R$ 1.000,00
        contaPoupanca1.saca(50);        // Saque de R$ 50,00
//      contaPoupanca1.atualiza(5);     // Atualização monetária de 5% (ajuste conforme necessário) //MELHORAR A LOGICA AQUI

        // Exibindo o saldo final da conta poupança 1 após as operações
        System.out.println("Saldo final da Conta Poupança 1: R$ " + contaPoupanca1.getSaldo());
    }
}
