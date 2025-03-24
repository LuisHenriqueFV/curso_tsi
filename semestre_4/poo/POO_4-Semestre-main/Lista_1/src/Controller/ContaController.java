package controller;

import model.Conta;

public class ContaController {
    public static void main(String[] args) {
        Conta conta1 = new Conta(1000);
        conta1.deposita(10);
    }
}
