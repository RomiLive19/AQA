/**
 * Lesson_3
 **/

public class Lesson_3_5 {
    public static void main(String[] args) {
        Mymetod(2024);
    }

    public static void Mymetod(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}