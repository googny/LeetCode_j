package twopointers.medium;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * @author googny
 * @since 2015/6/15
 */
public class _3Sum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0};
//        int[] nums = {-2, 0, 1, 1, 2};
        System.out.println(new _3Sum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //已经计算过的就跳过
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int _2Sum = nums[left] + nums[right];
                if (_2Sum > -a) {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (_2Sum < -a) {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    List<Integer> item = new LinkedList<>();
                    item.add(a);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    lists.add(item);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                }
            }
        }
        return lists;
    }
}
