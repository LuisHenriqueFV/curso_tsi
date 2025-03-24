package model;

import java.text.NumberFormat;

public class Desenvolvedor extends Funcionario{

    public Desenvolvedor(){
        super();
    }

    public Desenvolvedor(String nome, double salario){
        super(nome, salario);
//        this.setNome(nome);
//        this.setSalario(salario);
    }

    public double getBonus(){
        return this.getSalario() * 0.05;
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "nome='" + getNome() + '\'' +
                ", salario=" + NumberFormat.getCurrencyInstance().format(getSalario()) +
                ", bônus=" + NumberFormat.getCurrencyInstance().format(getBonus()) +
                '}';
    }


}
