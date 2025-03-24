package model;

public class Conta {
    private double saldo;

    public Conta() {
    }

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void deposita(double valor){
        this.setSaldo(this.getSaldo()+valor);
        System.out.println("Seu deposito de"+valor+" foi realizado! seu saldo atual é de:"+this.getSaldo());
    }
    public void saca(double valor){
        if( valor < this.getSaldo() ){

            this.setSaldo(this.getSaldo()-valor);
            this.atualiza(2.0);
            System.out.println("O saque de "+valor+" foi realizado!");
            System.out.println("Seu saldo atual é de " + this.getSaldo());
        }else{
            System.out.println("O saque de "+valor+" não foi realizado pois não possui saque suficiente");
        }

    }
    public void atualiza(double taxa){
        this.setSaldo(this.getSaldo()-this.getSaldo()*(taxa/100));
    }

    @Override
    public String toString() {
        return "\nConta{" +
                "saldo=" + saldo +
                '}';
    }
}
