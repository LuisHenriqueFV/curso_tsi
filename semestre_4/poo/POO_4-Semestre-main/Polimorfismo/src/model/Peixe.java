package model;

public class Peixe extends Animal {
    private double z;

    public Peixe() {
        super();
    }

    public Peixe(double x, double y) {
        this.z = z;
    }

    public Peixe(double x, double y, double z) {
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
//        this.x = x;
//        this.y = y;
        super.mover(x, y); //reutiliza o método mover que está na superclasse
        this.z = z;
    }

    public void desenhar(){
        System.out.println("\nDesenhar um peixe");
    }

    @Override
    public String toString() {
        return "Peixe{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                "}\n";
    }
}
