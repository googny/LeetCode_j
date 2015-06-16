package twopointers.medium;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target
 * number.
 * The function twoSum should return indices of the two numbers such that they add up to
 * the target, where index1 must be less than index2. Please note that your returned answers
 * (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * the input array is already sorted in ascending order.
 *
 * @author mti1301
 * @since 2015/6/15.
 */
public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8, 9, 10};
        System.out.println(Arrays.toString(new TwoSumII_InputArrayIsSorted().twoSum(nums, 19)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1}; // index1 and index2 not zero-based
            } else if (numbers[low] + numbers[high] < target) {
                do {
                    low++;
                } while (low < high && numbers[low - 1] == numbers[low]);
            } else {
                do {
                    high--;
                } while (low < high && numbers[high + 1] == numbers[high]);
            }
        }
        return new int[0];
    }
}
