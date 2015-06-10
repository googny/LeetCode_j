package array.easy;

import java.util.Arrays;

/**
 * @author mti1301
 * @since 2015/6/10.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate2(nums, 10);
    }

    // Solution 1
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] shadow = new int[len];
        k = k % len;
        for (int i = 0; i < len; i++) {
            shadow[i] = nums[(len - k + i) % len];
        }
        System.arraycopy(shadow, 0, nums, 0, len);
        System.out.println(Arrays.toString(nums));
    }

    // Solution 2
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        for (int i = 0; i < k; i++) {
            int temp = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    // Solution 3
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len);
        reverse(nums, 0, k);
        reverse(nums, k, len);
    }

    private void reverse(int[] nums, int start, int end) {
        int len = start + (end - start) / 2;
        int temp;
        for (int i = start; i < len; ++i) {
            temp = nums[i];
            nums[i] = nums[start + end - 1 - i];
            nums[start + end - 1 - i] = temp;
        }
    }
}
