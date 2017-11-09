package L03_Shapes;                     // some "final" declarations to pass in Judge

public class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    private final double getRadius() {
        return this.radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public double calculateArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
