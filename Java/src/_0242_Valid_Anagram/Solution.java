package _0242_Valid_Anagram;

import java.util.HashMap;

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了48.42%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了45.46%的用户
 */

public class Solution {

    public boolean isAnagram(String s, String t) {

        int[] a = new int[26], b = new int[26];
        for (char c : s.toCharArray()) a[c - 'a']++;
        for (char c : t.toCharArray()) b[c - 'a']++;

        for (int i = 0; i < 26; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isAnagram("anagram", "nagaram"));
        System.out.println((new Solution()).isAnagram("rat", "car"));
    }
}
