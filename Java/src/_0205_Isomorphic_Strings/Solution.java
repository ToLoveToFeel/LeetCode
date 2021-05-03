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

        HashMap<Character, Character> st = new HashMap<>(), ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);

            if (st.containsKey(a) && st.get(a) != b) return false;
            st.put(a, b);
            if (ts.containsKey(b) && ts.get(b) != a) return false;
            ts.put(b, a);
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
