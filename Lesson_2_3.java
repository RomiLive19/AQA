/**
 Lesson_2
 *
 */
public class Lesson_2_3 {
    public static void main(String[] args) {
        printColor();
    }
    public static void printColor() {
        int sum = 100;

        if (sum <= 0) {
            System.out.println("Красный");
        } else if (sum <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
}