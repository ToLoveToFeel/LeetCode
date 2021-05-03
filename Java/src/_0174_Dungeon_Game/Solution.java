package _0174_Dungeon_Game;

import java.util.Arrays;

/**
 * Date: 2021/5/3 19:14
 */
public class Solution {

    public int calculateMinimumHP(int[][] w) {

        int n = w.length, m = w[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], (int) 1e8);
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) f[i][j] = Math.max(1, 1 - w[i][j]);
                else {
                    if (i + 1 < n) f[i][j] = f[i + 1][j] - w[i][j];
                    if (j + 1 < m) f[i][j] = Math.min(f[i][j], f[i][j + 1] - w[i][j]);
                    f[i][j] = Math.max(1, f[i][j]);
                }
            }
        return f[0][0];
    }

    public static void main(String[] args) {

        int[][] w = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        System.out.println((new Solution()).calculateMinimumHP(w));  // 7
    }
}
