package controller;

import model.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UberController {
    public static void main(String[] args) {
        //---------- e.a ----------
        Usuario usuario1 = new Usuario(1L, "Humberto Matos", "humb@email.com", "5392345123");
        Motorista motorista1 = new Motorista(1L, "Henrique", "henrique@email.com", "539234434");
        Veiculo veiculo1 = new Veiculo(1L, "IUG-2344", "h6sw5Uhy#O", "Chevrolet", "Cruze", 2019, motorista1);

        Corrida corrida1 = new Corrida(1L, BigDecimal.valueOf(25.00), LocalDateTime.of(2024, 2, 10, 10, 1), LocalDateTime.of(2024, 5, 10, 10, 20), FormaDePagamento.CartaoCredito, Situacao.Faturada, usuario1, motorista1, veiculo1);
        Corrida corrida2 = new Corrida(2L, BigDecimal.valueOf(45.00), LocalDateTime.of(2024, 8, 10, 8, 0), LocalDateTime.of(2024, 8, 10, 9, 15), FormaDePagamento.CartaoCredito, Situacao.Faturada, usuario1, motorista1, veiculo1);

        //---------- e.b ----------
        List<Corrida> corridaList = new ArrayList<>();
        corridaList.add(corrida1);
        corridaList.add(corrida2);
        corridaList.sort(Comparator.comparing(Corrida::getValor).reversed());
        System.out.print("\nTodas as corridas do usuário (ordem decrescente, critério valor da corrida) " + usuario1.getNome());
        for (Corrida corrida : corridaList) {
            if(corrida.getUsuario().equals(usuario1)){
                System.out.println(corrida);
                System.out.print("----------------");
            }
        }

        //---------- e.c ----------
        System.out.print("\nTodas as corridas por motorista (ordem crescente, critério data inicio da corrida) " + motorista1.getNome());
        corridaList.sort(Comparator.comparing(Corrida::getDataInicio));
        for (Corrida corrida : corridaList) {
            if(corrida.getMotorista().equals(motorista1)){
                System.out.println(corrida);
                System.out.print("----------------");
            }
        }
        //---------- e.d ----------
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (Corrida corrida : corridaList) {
            if(corrida.getMotorista().equals(motorista1)){
                valorTotal = valorTotal.add(corrida.getValor());
            }
        }
        System.out.print("\n\nTotal de todas as corridas do motorista "
                + motorista1.getNome()
                + " = "
                + NumberFormat.getCurrencyInstance().format(valorTotal));

    }
}
