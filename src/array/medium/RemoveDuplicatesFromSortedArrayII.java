package array.medium;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author googny
 * @since 2015/6/15
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int i = 0;
        int j = i + 1;
        while (j < len) {
            if (nums[i] == nums[j]) {
                if (j - i >= 2) {
                    nums[i + 2] = nums[j+1];
                } else {
                    j++;
                }
            } else {

                i++;
                j++;
            }
        }
        return i;
    }
}
