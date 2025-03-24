package model;

public class Casa extends Imovel{
    private double tamanhoDoTerreno;

    public double getTamanhoDoTerreno() {
        return tamanhoDoTerreno;
    }

    public void setTamanhoDoTerreno(double tamanhoDoTerreno) {
        this.tamanhoDoTerreno = tamanhoDoTerreno;
    }

    public Casa(double tamanhoDoTerreno) {
        this.tamanhoDoTerreno = tamanhoDoTerreno;
    }

    public Casa(String tipoDeLogradouro, String logradouro, int numero, String complemento, String bairro,
                String cep, String cidade, double areaUtil, double precoDeCotacao, double precoDeVenda,
                double tamanhoDoTerreno) {
        super(tipoDeLogradouro, logradouro, numero, complemento, bairro, cep, cidade,
                areaUtil, precoDeCotacao, precoDeVenda);
        this.tamanhoDoTerreno = tamanhoDoTerreno;
    }

    @Override
    public Double getITBI() {
        return this.getPrecoDeVenda() * 0.03;
    }


    @Override
    public String toString() {
        return "Casa{" +
                "tamanhoDoTerreno=" + tamanhoDoTerreno +
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
