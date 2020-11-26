package _0000_study.classicalproblems.lcs;

import java.util.Arrays;

/**
 * Date: 2020/11/21 16:02
 * Content: 动态规划
 * 状态：dp[m][n]：text1[0...m] 和 text2[0...n] 的最长子序列的长度
 * 状态转移：
 * dp[m][n] = 1 + dp[m-1][n-1]   if text1[m] == text2[n]
 * dp[m][n] = Math.max(dp[m-1][n], dp[m][n-1])   if text1[m] != text2[n]
 * <p>
 * 执行用时：19 ms, 在所有 Java 提交中击败了7.52%的用户
 * 内存消耗：42.5 MB, 在所有 Java 提交中击败了31.63%的用户
 */
public class Solution {

    private int[][] dp;

    private int LCS(String text1, String text2, int m, int n) {

        if (m < 0 || n < 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (text1.charAt(m) == text2.charAt(n))
            dp[m][n] = 1 + LCS(text1, text2, m - 1, n - 1);
        else
            dp[m][n] = Math.max(LCS(text1, text2, m - 1, n), LCS(text1, text2, m, n - 1));

        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        if (len1 == 0 || len2 == 0)
            return 0;

        dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(dp[i], -1);
        }

        LCS(text1, text2, len1 - 1, len2 - 1);

        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {

//        String text1 = "abcde", text2 = "ace";  // 3
        String text1 = "abc", text2 = "def";  // 0
        System.out.println((new Solution()).longestCommonSubsequence(text1, text2));
    }
}
