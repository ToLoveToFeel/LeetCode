package _0329_Longest_Increasing_Path_in_a_Matrix;

import java.util.Arrays;

/**
 * Date: 2021/2/23 9:55
 * Content: 记忆化搜索
 * 执行用时：11 ms, 在所有 Java 提交中击败了53.36%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了23.33%的用户
 */
public class Solution {

    int n, m;
    int[][] f, w;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    private int dp(int x, int y) {

        if (f[x][y] != -1) return f[x][y];
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && w[x][y] < w[a][b])
                res = Math.max(res, dp(a, b) + 1);
        }
        f[x][y] = res;
        return f[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {

        w = matrix;
        n = w.length;
        m = w[0].length;
        f = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], -1);
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res = Math.max(res, dp(i, j));
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println((new Solution()).longestIncreasingPath(matrix));  // 4
    }
}
