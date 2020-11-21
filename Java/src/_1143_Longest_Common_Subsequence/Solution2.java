package _1143_Longest_Common_Subsequence;

import java.util.Arrays;

/**
 * Date: 2020/11/21 16:02
 * Content: 动态规划
 * 状态：dp[m+1][n+1]：text1[0...m] 和 text2[0...n] 的最长子序列的长度
 * 状态转移：
 * dp[m][n] = 1 + dp[m-1][n-1]   if text1[m] == text2[n]
 * dp[m][n] = Math.max(dp[m-1][n], dp[m][n-1])   if text1[m] != text2[n]
 * <p>
 * 执行用时：11 ms, 在所有 Java 提交中击败了79.57%的用户
 * 内存消耗：42.3 MB, 在所有 Java 提交中击败了61.26%的用户
 */
public class Solution2 {

    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        if (len1 == 0 || len2 == 0)
            return 0;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";  // 3
//        String text1 = "abc", text2 = "def";  // 0
        System.out.println((new Solution2()).longestCommonSubsequence(text1, text2));
    }
}
