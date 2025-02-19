package shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2.0, 3.0);
        Shape circle = new Circle(4.0);

        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
