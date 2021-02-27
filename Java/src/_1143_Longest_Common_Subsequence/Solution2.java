package _1143_Longest_Common_Subsequence;

/**
 * Date: 2020/11/21 16:02
 * Content: 动态规划
 * 执行用时：10 ms, 在所有 Java 提交中击败了80.02%的用户
 * 内存消耗：42.4 MB, 在所有 Java 提交中击败了27.03%的用户
 */
public class Solution2 {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length(), m = text2.length();
        char[] a = (" " + text1).toCharArray(), b = (" " + text2).toCharArray();

        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j]) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        return f[n][m];
    }

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";  // 3
//        String text1 = "abc", text2 = "def";  // 0
        System.out.println((new Solution2()).longestCommonSubsequence(text1, text2));
    }
}
