package lesson_5_2;

public class Rectangle implements Shape {
    public double width;
    public double height;
    public String color;
    public String borderColor;

    public Rectangle(double width, double height, String color, String borderColor) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor = borderColor;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public String color() {
        return color;
    }

    public String borderColor() {
        return borderColor;
    }
}
