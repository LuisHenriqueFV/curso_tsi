package Model;

public class ContaCorrente extends Conta implements Associado {

    public ContaCorrente() {
        super(0); // Define saldo inicial como 0 caso não seja passado
    }

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 2;
    }

    @Override
    public double lucros(int qdeCotas, double valorCota) {
        // Simples exemplo de cálculo de lucros para Conta Corrente
        return qdeCotas * (valorCota * 0.1);  // Exemplo fictício de cálculo de lucro
    }

    @Override
    public String toString() {
        return "ContaCorrente [saldo=" + saldo + "]";
    }
}
