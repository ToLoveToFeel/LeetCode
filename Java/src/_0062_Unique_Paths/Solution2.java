package _0062_Unique_Paths;

/**
 * Date: 2020/12/9 15:49
 * Content: 动态规划
 * 状态：dp[i][j] : 到达(i,j)的方法数
 * 初始状态：dp[0][j] = 1, dp[i][0] = 1
 * 状态转移：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m*n)
 */
public class Solution2 {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        // 计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).uniquePaths(3, 7));  // 28
        System.out.println((new Solution2()).uniquePaths(3, 2));  // 3
        System.out.println((new Solution2()).uniquePaths(7, 3));  // 28
        System.out.println((new Solution2()).uniquePaths(3, 3));  // 6
    }
}
