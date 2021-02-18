package _0392_Is_Subsequence;

/**
 * Date: 2021/2/18 9:57
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了77.29%的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了42.75%的用户
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {

        int k = 0;
        for (char c : t.toCharArray())
            if (k < s.length() && c == s.charAt(k))
                k++;
        return k == s.length();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isSubsequence("abc", "ahbgdc"));  // true
        System.out.println((new Solution()).isSubsequence("axc", "ahbgdc"));  // false
    }
}
