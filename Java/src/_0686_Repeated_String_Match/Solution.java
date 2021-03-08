package _0686_Repeated_String_Match;

/**
 * Created by WXX on 2021/3/8 11:05
 * 执行用时：5 ms, 在所有 Java 提交中击败了93.27%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了72.32%的用户
 */
public class Solution {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) sb.append(a);
        sb.append(a);
        int n = sb.length(), m = b.length();
        String t = " " + sb; b = " " + b;
        char[] s = t.toCharArray(), p = b.toCharArray();

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return (i + a.length() - 1) / a.length();
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).repeatedStringMatch("abcd", "cdabcdab"));  // 3
        System.out.println((new Solution()).repeatedStringMatch("a", "aa"));  // 2
    }
}
