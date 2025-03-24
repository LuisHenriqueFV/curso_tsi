package model;

import java.text.NumberFormat;

public class Gerente extends Funcionario implements Investidor{

    private String ticker;
    private int quantidade;

    public Gerente(){
        super();
    }

    public Gerente(String nome, double salario, String ticker, int quantidade){
        super(nome, salario);
        this.ticker = ticker;
        this.quantidade = quantidade;
//        this.setNome(nome);
//        this.setSalario(salario);
    }

    public double getBonus(){
        return this.getSalario() * 0.1;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nome='" + getNome() + '\'' +
                ", salario=" + NumberFormat.getCurrencyInstance().format(getSalario()) +
                ", bônus=" + NumberFormat.getCurrencyInstance().format(getBonus()) +
                ", ticker='" + ticker + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }


}
