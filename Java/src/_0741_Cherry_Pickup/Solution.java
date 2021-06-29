package _0741_Cherry_Pickup;

import java.util.Arrays;

/**
 * Date: 2021/6/29 22:17
 * 执行用时：43 ms, 在所有 Java 提交中击败了13.41%的用户
 * 内存消耗：46.1 MB, 在所有 Java 提交中击败了10.36%的用户
 */
public class Solution {

    static final int N = 55;
    int[][][] f = new int[N][N][N * 2];

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(f[i][j], (int) -1e8);
        f[1][1][2] = grid[0][0];
        for (int k = 3; k <= n * 2; k++)
            for (int i = Math.max(1, k - n); i <= Math.min(n, k - 1); i++)
                for (int j = Math.max(1, k - n); j <= Math.min(n, k - 1); j++) {
                    if (grid[i - 1][k - i - 1] == -1 || grid[j - 1][k - j - 1] == -1) continue;
                    int t = grid[i - 1][k - i - 1];
                    if (i != j) t += grid[j - 1][k - j - 1];
                    for (int a = i - 1; a <= i; a++)
                        for (int b = j - 1; b <= j; b++)
                            f[i][j][k] = Math.max(f[i][j][k], f[a][b][k - 1] + t);
                }
        return Math.max(0, f[n][n][n * 2]);
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1},
        };
        System.out.println((new Solution()).cherryPickup(grid));  // 5
    }
}
