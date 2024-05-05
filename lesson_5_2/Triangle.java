package lesson_5_2;

public class Triangle implements Shape {
    public double sideA, sideB, sideC;
    public String color;
    public String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.color = fillColor;
        this.borderColor = borderColor;
    }

    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public String color() {
        return color;
    }

    public String borderColor() {
        return borderColor;
    }
}
