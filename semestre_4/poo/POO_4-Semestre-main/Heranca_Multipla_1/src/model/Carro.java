package model;

public class Carro extends Veiculo implements Automovel{
    private int capacidadePortaMalas;

    private String renavam;
    private String chassi;
    private String placa;

    public Carro(){
        super();
    }

    public Carro(String renavam, String chassi, String placa, int numeroEixos, String propulsao, String marca, String modelo, int anoFabricacao,int capacidadePortaMalas) {
        super(numeroEixos, propulsao, marca, modelo, anoFabricacao);
        this.capacidadePortaMalas = capacidadePortaMalas;
        this.renavam = renavam;
        this.chassi = chassi;
        this.placa = placa;
    }

    public int getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(int capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
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
        return "Carro{" +
                "capacidadePortaMalas=" + capacidadePortaMalas +
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
