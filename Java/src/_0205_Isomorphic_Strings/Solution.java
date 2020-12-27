package _0205_Isomorphic_Strings;

import java.util.HashMap;

/**
 * 时间复杂度：O(len(s))
 * 空间复杂度：O(2 * len(s))
 * 执行用时：25 ms, 在所有 Java 提交中击败了10.76%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了81.66%的用户
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {

        assert s.length() == t.length();

        if (s.length() == 0 || s.length() == 1)
            return true;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) map1.put(s.charAt(i), t.charAt(i));
            else if (map1.get(s.charAt(i)) != t.charAt(i)) return false;

            if (!map2.containsKey(t.charAt(i))) map2.put(t.charAt(i), s.charAt(i));
            else if (map2.get(t.charAt(i)) != s.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isIsomorphic("egg", "add"));
        System.out.println((new Solution()).isIsomorphic("foo", "bar"));
        System.out.println((new Solution()).isIsomorphic("paper", "title"));
        System.out.println((new Solution()).isIsomorphic("ab", "aa"));
    }
}
