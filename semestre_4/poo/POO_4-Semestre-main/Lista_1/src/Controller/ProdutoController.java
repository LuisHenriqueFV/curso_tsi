package controller;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Arroz", "Branquinho", 10, 5);
        Produto produto2 = new Produto("Feijão", "Preto", 15, 2);
        Produto produto3 = new Produto("Açucar", "Confeiteiro", 25, 4);
        Produto produto4 = new Produto("Farinha", "acaraju", 5, 1);
        Produto produto5 = new Produto("Bala", "pao", 225, 42);


        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        System.out.println(produtos);
    }


}
