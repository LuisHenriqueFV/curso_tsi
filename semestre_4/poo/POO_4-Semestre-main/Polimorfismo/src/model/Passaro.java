package model;

public class Passaro extends Animal{
    private double z;

    public Passaro() {
        super();
    }

    public Passaro(double x, double y) {
        this.z = z;
    }

    public Passaro(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void mover(double x, double y, double z) {
        super.mover(x, y);
        this.z = z;
    }

    public void desenhar() {
        System.out.println("\nDesenhe um pássaro");
    }

    @Override
    public String toString() {
        return "Passaro{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
