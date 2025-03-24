package model;

public abstract class Animal {
    protected double x;
    protected double y;

    public Animal() {
        super();
    }

    public Animal(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void mover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void desenhar();

    @Override
    public String toString() {
        return "Animal{" +
                "x=" + x +
                ", y=" + y +
                "}\n";
    }
}
