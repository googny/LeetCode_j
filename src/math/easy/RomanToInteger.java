package math.easy;

/**
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author mti1301
 * @since 2015/6/17.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCVI"));
    }

    int romanCharToInt(char ch) {
        int d = 0;
        switch (ch) {
            case 'I':
                d = 1;
                break;
            case 'V':
                d = 5;
                break;
            case 'X':
                d = 10;
                break;
            case 'L':
                d = 50;
                break;
            case 'C':
                d = 100;
                break;
            case 'D':
                d = 500;
                break;
            case 'M':
                d = 1000;
                break;
        }
        return d;
    }

    public int romanToInt(String s) {
        if (s.length() <= 0) return 0;
        int result = romanCharToInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int left = romanCharToInt(s.charAt(i - 1));
            int cursor = romanCharToInt(s.charAt(i));
            if (left < cursor) {
                // 例如：MCM  result = M+C
                // 本次left = C cursor = M
                // result 需要先将left 去掉，再加上CM 也就是cursor-left
                result = result - left + (cursor - left);
            } else {
                result = result + cursor;
            }
        }
        return result;
    }
}
