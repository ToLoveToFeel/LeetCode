package _0803_Bricks_Falling_When_Hit;

import _0000_study._common.Output;

/**
 * Date: 2021/1/16 15:23
 * Content:
 * 执行用时：21 ms, 在所有 Java 提交中击败了62.14%的用户
 * 内存消耗：51.8 MB, 在所有 Java 提交中击败了34.31%的用户
 */
public class Solution {

    public static final int N = 40010;

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int[] p = new int[N], sz = new int[N];

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void merge(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 != p2) {
            p[p1] = p2;
            sz[p2] += sz[p1];
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {

        int m = grid.length, n = grid[0].length;
        // 根据hits内容先将砖块打掉
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = grid[i][j];
        for (int[] hit : hits) g[hit[0]][hit[1]] = 0;

        for (int i = 0; i <= m * n; i++) {
            p[i] = i;
            sz[i] = 1;
        }
        // 根据打掉砖块后的墙面g初始化并查集
        int ceiling = m * n;  // 代表天花板，所有挨着天花板的砖块都会合并到这个集合中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (g[i][j] == 1) {
                    // 说明(i, j)挨着天花板
                    if (i == 0) merge(ceiling, j);  // i * n + j == j
                    for (int k = 0; k < 4; k++) {  // 当前考察的砖块(i, j)的四周是否有砖块
                        int a = i + dx[k], b = j + dy[k];
                        if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == 1)
                            merge(i * n + j, a * n + b);
                    }
                }
        }

        int[] res = new int[hits.length];
        // 如果你先还原先掉落的，可能出现问题，本来一些位置应该有砖块的，但是还没有还原
        // 所以要反向还原
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 0) continue;  // 说明在没有砖块的地方敲打了一下，不会掉落砖块

            int pre = sz[find(ceiling)];  // 和天花板挨着的砖块(集合A)或者 挨着A的砖块的数量
            if (x == 0) merge(ceiling, y);  // 当前考察的砖块(x, y)挨着天花板
            for (int j = 0; j < 4; j++) {  // 当前考察的砖块(x, y)的四周是否有砖块
                int a = x + dx[j], b = y + dy[j];
                if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == 1)
                    merge(x * n + y, a * n + b);
            }
            int size = sz[find(ceiling)];
            // 这里必须加上max，否则第三个样例无法通过
            // 即当前砖块是因为其他砖块掉落而掉落的
            res[i] = Math.max(0, size - pre - 1);
            g[x][y] = 1;  // 加入当前考察的砖块(i, j)
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = {{1, 0}};
        int[] res = (new Solution()).hitBricks(grid, hits);
        Output.OutputBasicArray1D(res);
    }
}
