package _0064_Minimum_Path_Sum;

public class Solution3 {
    /*
    动态规划：自底向上
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int r = grid.length - 1;
        int c = grid[0].length - 1;
        int[][] dp = new int[r+1][c+1];
        dp[r][c] = grid[r][c];
        for (int i = r - 1; i >= 0; i--)
            dp[i][c] = dp[i+1][c] + grid[i][c];  // 填充最后一列的
        for (int j = c - 1; j >= 0; j--)
            dp[r][j] = dp[r][j+1] + grid[r][j];  // 填充最后一行的
        for (int i = r - 1; i >= 0; i--)  // 填充其他的
            for (int j = c - 1; j >= 0; j--)
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,2},
                {1,1}
        };
        System.out.println((new Solution3()).minPathSum(grid));
    }
}
