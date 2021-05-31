package _0417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/5/31 21:15
 * 执行用时：5 ms, 在所有 Java 提交中击败了91.84%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了51.96%的用户
 */
public class Solution {

    int n, m;
    int[][] w;
    int[][] st;

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        w = heights;
        if (w.length == 0 || w[0].length == 0) return new ArrayList<>();
        n = w.length; m = w[0].length;
        st = new int[n][m];

        for (int i = 0; i < m; i++) dfs(0, i, 1);  // 遍历第一行
        for (int i = 0; i < n; i++) dfs(i, 0, 1);  // 遍历第一列
        for (int i = 0; i < m; i++) dfs(n - 1, i, 2);  // 遍历最后一行
        for (int i = 0; i < n; i++) dfs(i, m - 1, 2);  // 遍历最后一列

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (st[i][j] == 3)
                    res.add(Arrays.asList(i, j));
        return res;
    }

    private void dfs(int x, int y, int t) {
        if ((st[x][y] & t) != 0) return;
        st[x][y] |= t;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && w[a][b] >= w[x][y])
                dfs(a, b, t);
        }
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 5},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };
        System.out.println((new Solution()).pacificAtlantic(heights));
    }
}
