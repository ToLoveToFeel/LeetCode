package _0064_Minimum_Path_Sum;

/**
 * 动态规划：自底向上
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了86.74%的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了75.14%的用户
 */
public class Solution3 {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        // 初始化
        for (int i = m - 2; i >= 0; i--)
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];  // 填充最后一列
        for (int j = n - 2; j >= 0; j--)
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];  // 填充最后一行

        // 计算
        for (int i = m - 2; i >= 0; i--) {  // 填充其他的
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2},
                {1, 1}
        };
        System.out.println((new Solution3()).minPathSum(grid));
    }
}
