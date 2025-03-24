package model;

public class Apartamento extends Imovel{
    private String nomeDoCondominio;


    public String getNomeDoCondominio() {
        return nomeDoCondominio;
    }

    public void setNomeDoCondominio(String nomeDoCondominio) {
        this.nomeDoCondominio = nomeDoCondominio;
    }

    public Apartamento(String nomeDoCondominio) {
        this.nomeDoCondominio = nomeDoCondominio;
    }

    public Apartamento(String tipoDeLogradouro, String logradouro, int numero, String complemento, String bairro, String cep, String cidade, double areaUtil, double precoDeCotacao, double precoDeVenda, String nomeDoCondominio) {
        super(tipoDeLogradouro, logradouro, numero, complemento, bairro, cep, cidade, areaUtil, precoDeCotacao, precoDeVenda);
        this.nomeDoCondominio = nomeDoCondominio;
    }

    @Override
    public Double getITBI() {
        return this.getPrecoDeCotacao() * 0.04;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "nomeDoCondominio='" + nomeDoCondominio + '\'' +
                ", tipoDeLogradouro='" + tipoDeLogradouro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", areaUtil='" + areaUtil + '\'' +
                ", precoDeCotacao=" + precoDeCotacao +
                ", precoDeVenda=" + precoDeVenda +
                '}';
    }


}
