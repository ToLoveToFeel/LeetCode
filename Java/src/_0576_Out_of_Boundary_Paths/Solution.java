package _0576_Out_of_Boundary_Paths;

/**
 * Date: 2021/8/15 10:16
 * Content:
 * 执行用时：9 ms, 在所有 Java 提交中击败了67.18%的用户
 * 内存消耗：37.5 MB, 在所有 Java 提交中击败了76.99%的用户
 */
public class Solution {

    static final int MOD = (int)1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int x, int y) {
        if (maxMove == 0) return 0;

        int[][][] f = new int[m][n][maxMove + 1];
        for (int i = 0; i < n; i++) {
            f[0][i][1] += 1;
            f[m - 1][i][1] += 1;
        }
        for (int i = 0; i < m; i++) {
            f[i][0][1] += 1;
            f[i][n - 1][1] += 1;
        }

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for (int k = 1; k <= maxMove; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    for (int u = 0; u < 4; u++) {
                        int a = i + dx[u], b = j + dy[u];
                        if  (a >= 0 && a < m && b >= 0 && b < n)
                            f[i][j][k] = (f[i][j][k] + f[a][b][k - 1]) % MOD;
                    }

        int res = 0;
        for (int k = 0; k <= maxMove; k++)
            res = (res + f[x][y][k]) % MOD;
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).findPaths(2, 2, 2, 0, 0));  // 6
    }
}
