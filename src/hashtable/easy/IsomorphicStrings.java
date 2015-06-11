package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p/>
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * <p/>
 * Note:
 * You may assume both s and t have the same length.
 *
 * @author mti1301
 * @since 2015/6/11.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("", ""));
    }

    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if(s.equals(t)){
            return true;
        }

        if (slen != tlen) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        boolean hasRepeat = false;
        for (int i = 0; i < slen; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            Integer sValue = sMap.get(sch);
            Integer tValue = tMap.get(tch);

            if (sValue == null && tValue == null) {// 都为null
                sMap.put(sch, i);
                tMap.put(tch, i);
            } else if ((sValue == null) ^ (tValue == null)) { // 其中一个为null
                return false;
            } else if (sValue != tValue) { // 都不为null
                return false;
            } else {
                hasRepeat = true;
            }
        }
        if(slen > 2){
            return hasRepeat;
        }else {
            return true;
        }
    }
}
