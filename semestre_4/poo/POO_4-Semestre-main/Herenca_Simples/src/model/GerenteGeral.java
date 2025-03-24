package model;

public class GerenteGeral extends Gerente {
    public GerenteGeral() {
    }

    public GerenteGeral(String nome, double salario) {
        super(nome, salario);
    }


    @Override
    public double getBonus() {
        return super.getBonus() * 0.40;
    }
}
