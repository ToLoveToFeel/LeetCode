package _0063_Unique_Paths_II;

/**
 * Date: 2020/12/9 16:51
 * Content: 动态规划
 * 基本和 Leetcode 0062 一样，对障碍物特殊处理一下即可
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了48.49%的用户
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++) {  // 初始化第一列
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {  // 初始化第一行
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        // 计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println((new Solution()).uniquePathsWithObstacles(obstacleGrid));  // 2
    }
}
