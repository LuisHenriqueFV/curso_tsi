package model;

public class Caminhao extends Veiculo implements Automovel{
    private int capacidadeDeCarga;

    private String renavam;
    private String chassi;
    private String placa;

    public Caminhao(){
        super();
    }

    public Caminhao(String renavam, String chassi, String placa, int numeroEixos, String propulsao, String marca, String modelo, int anoFabricacao,int capacidadeDeCarga) {
        super(numeroEixos, propulsao, marca, modelo, anoFabricacao);
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.renavam = renavam;
        this.chassi = chassi;
        this.placa = placa;
    }

    public int getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public void setCapacidadeDeCarga(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    @Override
    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Override
    public String getChassi() {
        return chassi;
    }

    @Override
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Caminhão{" +
                "capacidade de carga=" + capacidadeDeCarga +
                ", renavam='" + renavam + '\'' +
                ", chassi='" + chassi + '\'' +
                ", placa='" + placa + '\'' +
                ", número de eixos=" + getNumeroEixos() +
                ", propulsão='" + getPropulsao() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano de fabricação=" + getAnoFabricacao() +
                '}';
    }
}
