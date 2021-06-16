package _0877_Stone_Game;

/**
 * Date: 2021/6/16 9:10
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) f[i][i] = piles[i];
        for (int len = 2; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(f[i + 1][j] + piles[i], f[i][j - 1] + piles[j]);
            }
        return f[0][n - 1] > Math.min(f[1][n - 1], f[0][n - 2]);
    }

    public static void main(String[] args) {

        int[] piles = {5, 3, 4, 5};
        System.out.println((new Solution()).stoneGame(piles));  // true
    }
}
