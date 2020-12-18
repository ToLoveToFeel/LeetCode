package _0389_Find_the_Difference;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2020/10/17 10:31
 * Content:
 */
public class Solution {

    public char findTheDifference(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) - 1);
        }

        Set<Character> set = map.keySet();
        for (Character c : set) {
            if (map.get(c) == 1)
                return c;
        }

        throw new IllegalArgumentException("Input Error!");
    }

    public static void main(String[] args) {

//        String s = "abcd";
//        String t = "abcde";
        String s = "";
        String t = "y";
        System.out.println((new Solution()).findTheDifference(s, t));
    }
}
