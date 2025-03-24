package model;

public class DesenvolvedorPleno extends Desenvolvedor{
    public DesenvolvedorPleno() {
    }

    public DesenvolvedorPleno(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double getBonus() {
        return super.getBonus()*0.05;
    }
}
