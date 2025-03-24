package model;

public class DesenvolvedorSenior extends Desenvolvedor{
    public DesenvolvedorSenior() {
    }
    public DesenvolvedorSenior(String nome, double salario) {
        super(nome, salario);
    }
    @Override
    public double getBonus() {
        return super.getBonus()*0.10;
    }



}
