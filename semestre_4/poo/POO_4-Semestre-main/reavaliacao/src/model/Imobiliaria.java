package model;

public abstract class Imobiliaria implements Portfolio{
    protected String razaoSocial;
    protected String cnpj;
    protected double previsaoDeFaturamento;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getPrevisaoDeFaturamento() {
        return previsaoDeFaturamento;
    }

    public void setPrevisaoDeFaturamento(double previsaoDeFaturamento) {
        this.previsaoDeFaturamento = previsaoDeFaturamento;
    }

    public Imobiliaria() {
    }

    public Imobiliaria(String razaoSocial, String cnpj, double previsaoDeFaturamento) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.previsaoDeFaturamento = previsaoDeFaturamento;
    }

    @Override
    public abstract Double getITBI();

    @Override
    public String toString() {
        return "Imobiliaria{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", previsaoDeFaturamento=" + previsaoDeFaturamento +
                '}';
    }
}
