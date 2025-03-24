package model;

public class Bicicleta extends Veiculo{
    private int tamanhoRodas;
    private String chassi;

    public Bicicleta(){
        super();
    }

    public Bicicleta(int numeroEixos, String propulsao, String marca, String modelo, int anoFabricacao,int tamanhoRodas, String chassi) {
        super(numeroEixos, propulsao, marca, modelo, anoFabricacao);
        this.tamanhoRodas = tamanhoRodas;
        this.chassi = chassi;
    }

    public int getTamanhoRodas() {
        return tamanhoRodas;
    }

    public void setTamanhoRodas(int tamanhoRodas) {
        this.tamanhoRodas = tamanhoRodas;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "tamanho das rodas=" + tamanhoRodas +
                ", chassi='" + chassi + '\'' +
                "número de eixos=" + getNumeroEixos() +
                ", propulsão='" + getPropulsao() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano de fabricação=" + getAnoFabricacao() +
                '}';
    }
}
