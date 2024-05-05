/**
 Lesson_2
 *
 */
public class Lesson_2_2 {
    public static void main(String[] args) {
        checkSumSign();
    }

    public static void checkSumSign() {
        int a = -23;
        int b = 67;
        int sum = a + b;
        System.out.println(sum);
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
}