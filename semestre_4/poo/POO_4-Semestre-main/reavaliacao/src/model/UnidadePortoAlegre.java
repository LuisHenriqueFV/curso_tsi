package model;

public class UnidadePortoAlegre extends Imobiliaria{
    private double taxaDeComissao;

    public double getTaxaDeComissao() {
        return taxaDeComissao;
    }

    public void setTaxaDeComissao(double taxaDeComissao) {
        this.taxaDeComissao = taxaDeComissao;
    }

    public UnidadePortoAlegre(double taxaDeComissao) {
        this.taxaDeComissao = taxaDeComissao;
    }

    public UnidadePortoAlegre(String razaoSocial, String cnpj, double previsaoDeFaturamento, double taxaDeComissao) {
        super(razaoSocial, cnpj, previsaoDeFaturamento);
        this.taxaDeComissao = taxaDeComissao;
    }


    @Override
    public Double getITBI() {
        return this.getPrevisaoDeFaturamento() * 0.025;
    }

    @Override
    public String toString() {
        return "UnidadePortoAlegre{" +
                "taxaDeComissao=" + taxaDeComissao +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", previsaoDeFaturamento=" + previsaoDeFaturamento +
                '}';
    }
}
