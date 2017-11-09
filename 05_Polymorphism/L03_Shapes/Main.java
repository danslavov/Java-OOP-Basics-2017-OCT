package L03_Shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        Circle circle = new Circle(4);
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
