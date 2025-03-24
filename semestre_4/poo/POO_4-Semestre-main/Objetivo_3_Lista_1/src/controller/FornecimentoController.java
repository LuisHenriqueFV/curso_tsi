package controller;

import model.Fornecedor;
import model.Fornecimento;
import model.Produto;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FornecimentoController {
    public static void main(String[] args) {

        // --------- f.a ---------
        Fornecedor fornecedor1 = new Fornecedor("16.785.406/0001-67", "Silva Jardim LTDA", "SóCódigo", "socodigo@email.com", "5355551234", null);

        Produto produto1 = new Produto("DTK234", "Arroz", "Arroz Ceolin 5kg", 100, BigDecimal.valueOf(13.0), BigDecimal.valueOf(18.9), List.of(fornecedor1));
        Produto produto2 = new Produto("DTK232", "Feijão", "Feijão Tordilho 1kg", 100, BigDecimal.valueOf(5.0), BigDecimal.valueOf(8.9), List.of(fornecedor1));

        Fornecimento fornecimento1 = new Fornecimento(LocalDateTime.of(2024, 7, 1, 9, 28),100, produto1.getPrecoDeCusto(), produto1, fornecedor1);
        Fornecimento fornecimento2 = new Fornecimento(LocalDateTime.of(2024, 7, 2, 10, 0), 100, produto2.getPrecoDeCusto(), produto2, fornecedor1);

        // ---------- f.b ---------
        List<Fornecimento> fornecimentoList = new ArrayList<>();
        fornecimentoList.add(fornecimento1);
        fornecimentoList.add(fornecimento2);

        BigDecimal totalFornecimento = BigDecimal.ZERO;
        for (Fornecimento fornecimento : fornecimentoList) {
            totalFornecimento = totalFornecimento.add(fornecimento.getTotal());
        }
        System.out.println("\nRelatório de fornecimentos");
        System.out.println(fornecimentoList);
        System.out.println("Total de Fornecimentos: " + NumberFormat.getCurrencyInstance().format(totalFornecimento));


    }






}
