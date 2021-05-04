package _0221_Maximal_Square;

/**
 * Date: 2020/10/27 13:38
 * Content:
 * 动态规划
 * 状态：dp[i][j]: 表示以matrix[i][j]为右下角，且只包含 1 的正方形的边长最大值
 * 状态转移：
 * dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1，如果 matrix[i][j] == '1'
 * dp[i][j] = 0，如果 matrix[i][j] == '0'
 * <p>
 * 执行用时：6 ms, 在所有 Java 提交中击败了84.34%的用户
 * 内存消耗：41.8 MB, 在所有 Java 提交中击败了79.57%的用户
 * <p>
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m*n)
 * 对比 Leetcode 1277. 统计全为 1 的正方形子矩阵
 */
public class Solution2 {

    public int maximalSquare(char[][] matrix) {

        int n = matrix.length, m = matrix[0].length;

        int[][] dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
        }

        return res * res;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println((new Solution2()).maximalSquare(matrix));
    }
}
