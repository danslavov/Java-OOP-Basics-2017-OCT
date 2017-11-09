package L02_MethodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
    }

    public double area() {
        return this.sideA * this.sideB;
    }
}
