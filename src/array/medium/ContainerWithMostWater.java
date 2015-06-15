package array.medium;

/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * <p/>
 * Note: You may not slant the container.
 *
 * @author mti1301
 * @since 2015/6/14.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] height = {4, 4, 2, 11, 0, 11, 5, 11, 13, 8};
        long start = System.currentTimeMillis();
        System.out.println(new ContainerWithMostWater().maxArea(height));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int result = Math.min(height[low], height[high]) * (high - low);
        while (low < high) {
            System.out.println("low= " + low + ",high= " + high);
            int area = Math.min(height[low], height[high]) * (high - low);
            int lowArea = Math.min(height[low + 1], height[high]) * (high - low - 1);
            int highArea = Math.min(height[low], height[high - 1]) * (high - low - 1);

            result = Math.max(result, area);
            if (result > lowArea && result > highArea) {
                high--;
            } else {
                if (highArea >= lowArea) {
                    result = highArea;
                    high--;
                } else {
                    result = lowArea;
                    low++;
                }
            }
        }
        return result;
    }
}
