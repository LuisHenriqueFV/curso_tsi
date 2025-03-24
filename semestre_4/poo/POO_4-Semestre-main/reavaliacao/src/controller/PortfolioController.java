package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class PortfolioController {
    public static void main(String[] args) {
        // --------------------Questão B--------------------
        // Criação de duas instâncias da classe Casa
        Casa casa1 = new Casa(
                "Rua", "Flores da Cunha", 789, "Casa A",
                "Jardim América", "97050-100", "Pelotas",
                250.0, 750000.0, 700000.0, 350.0
        );

        Casa casa2 = new Casa(
                "Travessa", "Castro Alves", 321, "Casa B",
                "São José", "97500-200", "Pelotas",
                180.0, 580000.0, 540000.0, 280.0
        );

        // Criação de duas instâncias da classe Apartamento
        Apartamento apto1 = new Apartamento(
                "Avenida", "Independência", 567, "Apto 302",
                "Moinhos de Vento", "90035-200", "Porto Alegre",
                85.0, 320000.0, 310000.0, "Edifício Bela Vista"
        );

        Apartamento apto2 = new Apartamento(
                "Rua", "General Câmara", 123, "Apto 104",
                "Centro Histórico", "90010-300", "Porto Alegre",
                95.0, 410000.0, 400000.0, "Condomínio Imperial"
        );

        // Criação de uma instância da classe UnidadePelotas
        UnidadePelotas unidadePelotas = new UnidadePelotas(
                "Imobiliária Litoral", "47.123.456/0001-12",
                1200000.0, 4.5
        );

        // Criação de uma instância da classe UnidadePortoAlegre
        UnidadePortoAlegre unidadePortoAlegre = new UnidadePortoAlegre(
                "Imobiliária Capital", "87.654.321/0001-34",
                2500000.0, 5.8
        );

        // --------------------Questão C--------------------
        // Exibindo as instâncias criadas
        System.out.println("Casas:");
        System.out.println(casa1);
        System.out.println(casa2);

        System.out.println("\nApartamentos:");
        System.out.println(apto1);
        System.out.println(apto2);

        System.out.println("\nUnidades da Imobiliária:");
        System.out.println(unidadePelotas);
        System.out.println(unidadePortoAlegre);

        // --------------------Questão D--------------------
        // Criando uma única coleção do tipo List<Portfolio>
        List<Portfolio> listaPortfolio = new ArrayList<>();

        // Adicionando os objetos na coleção
        listaPortfolio.add(casa1);
        listaPortfolio.add(casa2);
        listaPortfolio.add(apto1);
        listaPortfolio.add(apto2);
        listaPortfolio.add(unidadePelotas);
        listaPortfolio.add(unidadePortoAlegre);

        // Imprimindo a coleção
        System.out.println("\nColeção de Portfolio:");
        for (Portfolio item : listaPortfolio) {
            System.out.println(item);
        }


        // --------------------Questão F--------------------
        System.out.println("\nEstimativas de ITBI:");
        for (Portfolio item : listaPortfolio) {
            if (item instanceof Casa || item instanceof Apartamento || item instanceof UnidadePortoAlegre || item instanceof UnidadePelotas) {
                double itbiEstimado = item.getITBI();
                System.out.println(item.getClass().getSimpleName() + " - Estimativa de ITBI: R$ " + itbiEstimado);
            }
        }

        // --------------------Questão G--------------------
        double previsaoFaturamentoPelotas = 0.0;
        double previsaoFaturamentoPortoAlegre = 0.0;

        // Percorrendo a lista para calcular a previsão de faturamento e o ITBI para cada unidade
        for (Portfolio item : listaPortfolio) {
            if (item instanceof Imovel) {
                double precoCotacao = ((Imovel) item).getPrecoDeCotacao();
                String cidade = ((Imovel) item).getCidade();

                // Verificando a cidade e somando à previsão de faturamento correspondente
                if (cidade.equals("Pelotas")) {
                    previsaoFaturamentoPelotas += precoCotacao;
                } else if (cidade.equals("Porto Alegre")) {
                    previsaoFaturamentoPortoAlegre += precoCotacao;
                }
            }
        }

        // Calculando o ITBI estimado para cada unidade com base na previsão de faturamento
        double itbiEstimadoPelotas = previsaoFaturamentoPelotas * 0.02; // 2% para Pelotas
        double itbiEstimadoPortoAlegre = previsaoFaturamentoPortoAlegre * 0.025; // 2.5% para Porto Alegre

        // Imprimindo os resultados
        System.out.println("\nPrevisão de Faturamento e ITBI Estimado por Unidade da Imobiliária:");
        System.out.println("Unidade Pelotas:");
        System.out.println("Previsão de Faturamento: R$ " + previsaoFaturamentoPelotas);
        System.out.println("ITBI Estimado: R$ " + itbiEstimadoPelotas);

        System.out.println("\nUnidade Porto Alegre:");
        System.out.println("Previsão de Faturamento: R$ " + previsaoFaturamentoPortoAlegre);
        System.out.println("ITBI Estimado: R$ " + itbiEstimadoPortoAlegre);

        // --------------------Questão H--------------------
        // Ordenando a lista de imóveis por preço de cotação em ordem decrescente
        List<Imovel> listaImoveis = new ArrayList<>();
        for (Portfolio item : listaPortfolio) {
            if (item instanceof Imovel) {
                listaImoveis.add((Imovel) item);
            }
        }

        Collections.sort(listaImoveis, new Comparator<Imovel>() {
            @Override
            public int compare(Imovel i1, Imovel i2) {
                return Double.compare(i2.getPrecoDeCotacao(), i1.getPrecoDeCotacao()); // Ordem decrescente
            }
        });

        // Imprimindo os imóveis ordenados
        System.out.println("\nImóveis por Preço de Cotação em Ordem Decrescente:");
        for (Imovel imovel : listaImoveis) {
            System.out.println(imovel.getClass().getSimpleName() + " - Preço de Cotação: R$ " + imovel.getPrecoDeCotacao());
        }

        // --------------------Questão I--------------------
        System.out.println("\nUnidades da Imobiliária por Previsão de Faturamento em Ordem Decrescente:");

        // Criar uma lista para armazenar as unidades
        List<Imobiliaria> listaUnidades = new ArrayList<>();

        // Filtrar as instâncias de Imobiliaria e adicioná-las à lista
        for (Portfolio item : listaPortfolio) {
            if (item instanceof Imobiliaria) {
                listaUnidades.add((Imobiliaria) item);
            }
        }

        // Ordenar a listaUnidades por previsão de faturamento em ordem decrescente
        Collections.sort(listaUnidades, new Comparator<Imobiliaria>() {
            @Override
            public int compare(Imobiliaria u1, Imobiliaria u2) {
                return Double.compare(u2.getPrevisaoDeFaturamento(), u1.getPrevisaoDeFaturamento()); // Ordem decrescente
            }
        });

        // Imprimir as unidades ordenadas
        for (Imobiliaria unidade : listaUnidades) {
            System.out.println(unidade.getClass().getSimpleName() + " - Previsão de Faturamento: R$ " + unidade.getPrevisaoDeFaturamento());
        }




    }
}

