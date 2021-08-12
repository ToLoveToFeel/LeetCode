package _0516_Longest_Palindromic_Subsequence;

/**
 * Date: 2021/8/12 09:43
 * Content:
 * 执行用时：39 ms, 在所有 Java 提交中击败了62.85%的用户
 * 内存消耗：48.4 MB, 在所有 Java 提交中击败了54.86%的用户
 */
public class Solution {

    public int longestPalindromeSubseq(String cs) {
        char[] s = cs.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        for (int len = 1; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) f[i][j] = 1;
                else {
                    if (s[i] == s[j]) f[i][j] = f[i + 1][j - 1] + 2;
                    f[i][j] = Math.max(f[i][j], Math.max(f[i][j - 1], f[i + 1][j]));
                }
            }
        return f[0][n - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).longestPalindromeSubseq("bbbab"));  // 4
        System.out.println((new Solution()).longestPalindromeSubseq("cbbd"));  // 2
    }
}
