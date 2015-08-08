package string.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 * @author mti1301
 * @since 2015/6/23.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
    }

    /**
     * easy
     *
     * @param s 字符串
     * @return 配对？
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
