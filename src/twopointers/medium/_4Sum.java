package twopointers.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * @author googny
 * @since 2015/6/15
 */
public class _4Sum {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0, 0, 0, 0, 0, 0};
        System.out.println(new _4Sum().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int _3Sum = target - a;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int _2Sum = _3Sum - b;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > _2Sum) {
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);
                    } else if (sum < _2Sum) {
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                    } else {
                        List<Integer> item = new LinkedList<>();
                        item.add(a);
                        item.add(b);
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
        }
        return lists;
    }
}
