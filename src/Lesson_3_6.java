import java.util.Arrays;

/**
 * Lesson_3
 **/

public class Lesson_3_6 {
    public static void main(String args[]) {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1 - nums[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}