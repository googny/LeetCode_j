package math.easy;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 *
 * @author googny
 * @since 2015/6/17
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(-10));
        System.out.println(reverse(10));
        System.out.println(reverse(1000000003));
    }

    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int offset = 0;
        int len = chars.length - 1;
        if (chars[0] == '-') {
            offset = 1;
        }
        for (int i = 0; i < (len + 1) / 2; i++) {
            char ch = chars[i + offset];
            chars[i + offset] = chars[len - i];
            chars[len - i] = ch;
        }
        int result;
        try {
            result = Integer.valueOf(new String(chars));
        } catch (NumberFormatException nfe) {
            result = 0;
        }
        return result;
    }

}
