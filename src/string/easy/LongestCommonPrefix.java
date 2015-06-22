package string.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @author googny
 * @since 2015/6/22
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = new String[]{"helloworld", "helloMyHome", "hejjo"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }

    /**
     * 主要算法思想:
     * ① 找到所有字符串的最小长度
     * ② 遍历字符串，找到最长公共前缀的结束下标
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }

        int cur = 0;
        while (cur < minLen) {
            for (int i = 0; i < strs.length - 1; ++i) {
                if (strs[i].charAt(cur) == strs[i + 1].charAt(cur)) {
                    continue;
                } else {
                    return strs[0].substring(0, cur);
                }
            }
            ++cur;
        }
        return strs[0].substring(0, cur);
    }
}
