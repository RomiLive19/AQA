import java.util.Arrays;

/**
 * Lesson_3
 **/

public class Lesson_3_10 {
    public static void main(String[] args) {
        int len = 5;
        int initialValue = 7;
        int[] matrix = newmatrix(len, initialValue);
        System.out.println(Arrays.toString(matrix));
    }

    public static int[] newmatrix(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}