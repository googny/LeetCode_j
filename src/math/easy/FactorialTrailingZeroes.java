package math.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * @author mti1301
 * @since 2015/6/17.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }

    public int trailingZeroes(int n) {
        int near = 5 * (n / 5);
        int count = 0;
        while (near != 0) {
            int cursor = near;
            while (cursor % 5 == 0) {
                count++;
                cursor = cursor / 5;
            }
            near = near - 5;
        }
        return count;
    }
}
