package array.medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p/>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author googny
 * @since 2015/6/13.
 */
public class _3SumClosest {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(new _3SumClosest().threeSumClosest(nums, 9));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int low = i + 1;
            int high = len - 1;
            while (low < high) {
                int b = nums[low];
                int c = nums[high];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < distance) {
                    result = sum;
                    distance = Math.abs(sum - target);
                }

                if (sum < target) {
                    while (low < len-1 && nums[low] == nums[low + 1]) low++;
                    low++;
                } else {
                    while (high > 0 && nums[high] == nums[high - 1]) high--;
                    high--;
                }
            }

        }
        return result;
    }

}
