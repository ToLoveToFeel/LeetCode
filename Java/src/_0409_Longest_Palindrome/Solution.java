package _0409_Longest_Palindrome;

import java.util.HashMap;

/**
 * Date: 2021/5/31 16:39
 * 执行用时：8 ms, 在所有 Java 提交中击败了31.94%的用户
 * 内存消耗：36.9 MB, 在所有 Java 提交中击败了32.65%的用户
 */
public class Solution {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) hash.put(c, hash.getOrDefault(c, 0) + 1);
        int res = 0;
        for (int v : hash.values()) res += v / 2 * 2;
        if (res < s.length()) res++;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).longestPalindrome("abccccdd"));  // 7
    }
}
