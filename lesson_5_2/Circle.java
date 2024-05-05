package lesson_5_2;

public class Circle implements Shape {
    public double radius;
    public String color;
    public String borderColor;

    public Circle(double radius, String color, String borderColor) {
        this.radius = radius;
        this.color = color;
        this.borderColor = borderColor;
    }

    public double area() {
        return 3.141592653589793 * radius * radius;
    }

    public double perimeter() {
        return 2 * 3.141592653589793 * radius;
    }

    public String color() {
        return color;
    }

    public String borderColor() {
        return borderColor;
    }
}
