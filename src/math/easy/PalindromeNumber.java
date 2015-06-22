package math.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @author googny
 * @since 2015/6/18
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(010));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 1;
        int tmp = x;
        while ((tmp = (tmp / 10)) != 0) {
            len++;
        }
        for (int i = 0; i < len / 2; i++) {
            int left = (x / (int) Math.pow(10, i)) % 10;
            int right = (x / (int) Math.pow(10, len - i - 1)) % 10;
            if (left != right)
                return false;
        }
        return true;
    }
}
