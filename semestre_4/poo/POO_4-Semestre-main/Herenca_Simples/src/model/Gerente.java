package model;

public class Gerente extends Funcionario{
    public Gerente() {
    }

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }
    public double getBonus(){

        return getSalario()*0.20;

    }
}
