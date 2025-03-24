package model;

public abstract class Imovel implements Portfolio {
    protected String tipoDeLogradouro;
    protected String logradouro;
    protected int numero;
    protected String complemento;
    protected String bairro;
    protected String cep;
    protected String cidade;
    protected double areaUtil;
    protected double precoDeCotacao;
    protected double precoDeVenda;


    public String getTipoDeLogradouro() {
        return tipoDeLogradouro;
    }

    public void setTipoDeLogradouro(String tipoDeLogradouro) {
        this.tipoDeLogradouro = tipoDeLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    public double getPrecoDeCotacao() {
        return precoDeCotacao;
    }

    public void setPrecoDeCotacao(double precoDeCotacao) {
        this.precoDeCotacao = precoDeCotacao;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Imovel() {
    }

    public Imovel(String tipoDeLogradouro, String logradouro, int numero, String complemento, String bairro, String cep, String cidade, double areaUtil, double precoDeCotacao, double precoDeVenda) {
        this.tipoDeLogradouro = tipoDeLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.areaUtil = areaUtil;
        this.precoDeCotacao = precoDeCotacao;
        this.precoDeVenda = precoDeVenda;
    }

    @Override
    public abstract Double getITBI();

    @Override
    public String toString() {
        return "Imovel{" +
                "tipoDeLogradouro='" + tipoDeLogradouro + '\'' +
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
