package _1277_Count_Square_Submatrices_with_All_Ones;

/**
 * Date: 2020/10/27 14:27
 * Content:
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 * 动态规划
 * 状态：dp[i][j]: 表示以matrix[i][j]为右下角，且只包含 1 的正方形的边长最大值
 * 状态转移：
 * dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1，如果 matrix[i][j] == '1'
 * dp[i][j] = 0，如果 matrix[i][j] == '0'
 * 将所有dp相加可以得到结果
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了87.01%的用户
 * 内存消耗：50.8 MB, 在所有 Java 提交中击败了67.73%的用户
 */
public class Solution {
    public int countSquares(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] f = new int[n][m];
        int res = 0;  // 正方形数目
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) f[i][j] = 1;
                    else f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    res += f[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {  // 15
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1}
//        };
        int[][] matrix = {  // 7
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println((new Solution()).countSquares(matrix));
    }
}
