package lesson_5_2;

public interface Shape {
    double area();

    double perimeter();

    String color();

    String borderColor();

    default void printInfo() {
        System.out.println("Периметр: " + perimeter() + ", Площадь: " + area() + ", Цвет фона: " + color() + ", Цвет границ: " + borderColor());
    }
}

