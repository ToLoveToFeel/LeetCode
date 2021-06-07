package _0000_study._leetcode._lcp._LCP_04_Broken_Board_Dominoes;

import java.util.Arrays;

/**
 * Date: 2021/6/7 15:25
 */
public class Solution {

    int n, m;
    int[][] g;
    int[] match;
    boolean[] st;

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public int domino(int _n, int _m, int[][] broken) {
        n = _n; m = _m;
        g = new int[n][m];  // 1表示坏掉的格子
        match = new int[n * m];
        st = new boolean[n * m];
        for (int i = 0; i < broken.length; i++) {
            int a = broken[i][0], b = broken[i][1];
            g[a][b] = 1;
        }

        Arrays.fill(match, -1);
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if ((i + j) % 2 != 0 && g[i][j] != 1) {
                    Arrays.fill(st, false);
                    if (find(i * m + j)) res++;
                }
        return res;
    }

    private boolean find(int x) {
        for (int i = 0; i < 4; i++) {
            int a = x / m + dx[i], b = x % m + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m || g[a][b] == 1) continue;

            int j = a * m + b;
            if (!st[j]) {
                st[j] = true;
                // 如果女孩j没有男朋友，或者她原来的男朋友能够预定其它喜欢的女孩。配对成功
                if (match[j] == -1 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] broken = {{1, 0}, {1, 1}};
        System.out.println((new Solution()).domino(2, 3, broken));  // 2
    }
}
