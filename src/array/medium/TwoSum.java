package array.medium;

import java.util.*;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @author Googny
 * @since 2015/6/11.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 11, 15};
        int target = 2;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
    // Solution
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,int[]> location = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer value = map.get(nums[i]);
            if(value != null){
                location.put(nums[i],new int[]{value,(i+1)});
            }
            map.put(nums[i], i + 1);
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            int els = target - key;
            if (map.get(els) != null) {
                if(els == key){
                    return location.get(els);
                }
                return new int[]{Math.min(map.get(key), map.get(els)), Math.max(map.get(key), map.get(els))};
            }
        }
        return new int[0];
    }
}
