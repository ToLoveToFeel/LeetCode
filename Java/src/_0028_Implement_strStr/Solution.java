package _0028_Implement_strStr;

/**
 * Date: 2020/9/19 21:22
 * Content: kmp算法
 * 执行用时：3 ms, 在所有 Java 提交中击败了39.16%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了38.65%的用户
 */
public class Solution {

    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        int m = haystack.length(), n = needle.length();
        char[] s = (" " + haystack).toCharArray(), p = (" " + needle).toCharArray();

        int[] ne = new int[n + 10];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) return i - n;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).strStr("", ""));  // 0
        System.out.println((new Solution()).strStr("hello", "ll"));  // 2
        System.out.println((new Solution()).strStr("aaaaa", "bba"));  // -1
        System.out.println((new Solution()).strStr("mississippi", "issippi"));  // 4
    }
}
