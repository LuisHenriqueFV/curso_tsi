package model;

public class GerenteDesenvolvedores extends Gerente {
    public GerenteDesenvolvedores() {
    }

    public GerenteDesenvolvedores(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double getBonus() {
        return super.getBonus()*0.20;
    }
}
