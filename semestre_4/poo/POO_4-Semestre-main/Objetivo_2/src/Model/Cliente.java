package Model;

public class Cliente implements Associado {
    private String nome;

    @Override
    public double lucros(int qdeCotas, double valorCota) {
        // Simples exemplo de cálculo de lucros para Cliente
        return qdeCotas * (valorCota * 0.05);  // Exemplo fictício de cálculo de lucro
    }

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nCliente{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
