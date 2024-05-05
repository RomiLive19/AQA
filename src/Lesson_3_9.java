/**
 * Lesson_3
 **/

public class Lesson_3_9 {
    public static void main(String[] args) {
        int size = 3;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }
    }
}