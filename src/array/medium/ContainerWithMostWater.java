package array.medium;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 *
 * @author googny
 * @since 2015/6/14.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {2, 3, 10, 5, 7, 8, 9};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;

        int maxArea = 0;

        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, area);
            /*
            初始阶段x轴方向上应该是最长的，以后要依次递减，所以无论low后移还是high前移，x轴上距离是相等的。
            因此比较low和high指向值的大小，值小的一边先移动，才找到更大的值的可能，否则y轴方向上一直是小值
             */
//            if (height[low] > height[high]) {
//                high--;
//            } else {
//                low++;
//            }

            /*
            参考网上一些同志的做法，如果发现移动后（前移或后移）的元素比前一个（前/后）元素更小的话，
            不用计算area的值（面积肯定更小（因为x轴距离变小，值也变小）），继续移动，以期发现更大的值。
             */
            if (height[low] > height[high]) {
                do {
                    high--;
                }
                while (low < high && height[high + 1] > height[high]);
            } else {
                do {
                    low++;
                } while (low < high && height[low - 1] > height[low]);
            }
        }
        return maxArea;
    }
}
