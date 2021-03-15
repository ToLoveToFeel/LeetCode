package _0695_Max_Area_of_Island;

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了18.82%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了99.62%的用户
 */
public class Solution2 {

    private int n, m;
    private int[][] g;
    private final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    private boolean[][] st;  // 记录节点是否访问过

    public int maxAreaOfIsland(int[][] grid) {

        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        if (m == 0) return 0;

        this.g = grid;
        st = new boolean[n][m];  // 默认为false

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!st[i][j] && grid[i][j] == 1)
                    res = Math.max(res, dfs(i, j));

        return res;
    }

    // 返回某个陆地大小
    private int dfs(int sx, int sy) {
        st[sx][sy] = true;
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int a = sx + d[i][0], b = sy + d[i][1];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b] && g[a][b] == 1)
                res += dfs(a, b);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println((new Solution2()).maxAreaOfIsland(grid));
    }
}
