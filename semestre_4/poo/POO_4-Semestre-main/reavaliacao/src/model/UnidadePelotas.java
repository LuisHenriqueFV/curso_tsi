package model;

public class UnidadePelotas extends Imobiliaria{
    private double taxaDeComissao;



    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }

    public void setTaxaDeComissao(double taxaDeComissao) {
        this.taxaDeComissao = taxaDeComissao;
    }

    public UnidadePelotas(double taxaDeComissao) {
        this.taxaDeComissao = taxaDeComissao;
    }

    public UnidadePelotas(String razaoSocial, String cnpj, double previsaoDeFaturamento, double taxaDeComissao) {
        super(razaoSocial, cnpj, previsaoDeFaturamento);
        this.taxaDeComissao = taxaDeComissao;
    }

    @Override
    public Double getITBI() {
        return this.getPrevisaoDeFaturamento() * 0.02;
    }

    @Override
    public String toString() {
        return "UnidadePelotas{" +
                "taxaDeComissao=" + taxaDeComissao +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", previsaoDeFaturamento=" + previsaoDeFaturamento +
                '}';
    }
}
