package model;

public class Cachorro extends Animal {

    public Cachorro() {
        super();
    }

    public Cachorro(double x, double y) {
        super(x, y);
    }

    public void desenhar() {
        System.out.println("\nDesenha um cachorro");
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "y=" + y +
                ", x=" + x +
                "}\n";
    }
}
