import java.util.Arrays;

/**
 * Lesson_3
 **/

public class Lesson_3_8 {
    public static void main(String args[]) {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}