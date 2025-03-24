package model;

public class Desenvolvedor extends Funcionario{
    public Desenvolvedor() {
    }

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }
    public double getBonus(){
        return getSalario() * 0.05;
    }


}
