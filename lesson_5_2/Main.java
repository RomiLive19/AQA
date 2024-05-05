package lesson_5_2;

/**
 * Lesson_5
 **/

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "green", "black");
        Shape rectangle = new Rectangle(4.0, 6.0, "blue", "green");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "yellow", "blue");

        System.out.println("Круг: ");
        circle.printInfo();
        System.out.println();
        System.out.println("Прямоугольник: ");
        rectangle.printInfo();
        System.out.println();
        System.out.println("Треугольник: ");
        triangle.printInfo();
    }
}

