package Model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [saldo=" + saldo + "]";
    }
}
