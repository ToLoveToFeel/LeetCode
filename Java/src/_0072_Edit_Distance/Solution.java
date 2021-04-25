package _0072_Edit_Distance;

/**
 * Date: 2021/4/25 22:05
 */
public class Solution {

    public int minDistance(String word1, String word2) {

        int n = word1.length(), m = word2.length();
        char[] a = (" " + word1).toCharArray(), b = (" " + word2).toCharArray();

        int[][] f = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) f[0][i] = i;
        for (int i = 0; i <= n; i++) f[i][0] = i;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                if (a[i] == b[j]) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
            }
        return f[n][m];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).minDistance("horse", "ros"));  // 3
    }
}
