package _0463_Island_Perimeter;

/**
 * Date: 2020/10/30 10:07
 * Content:
 * dfs
 * 执行用时：14 ms, 在所有 Java 提交中击败了8.57%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了5.05%的用户
 */
public class Solution2 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    int m, n;  // 行数，列数
    private static final int WATER = 0;  // 代表水域
    private static final int ISLAND = 1;  // 代表陆地
    private static final int VISITED = 2;  // 代表已经访问过的陆地

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 考虑从陆地(x, y)出发，返回未访问的岛屿的周长
    private int dfs(int[][] grid, int x, int y) {
        if (!inArea(x, y))  // 从一个岛屿方格走向网格边界，周长加 1
            return 1;
        if (grid[x][y] == WATER)  // 从一个岛屿方格走向水域方格，周长加 1
            return 1;
        if (grid[x][y] == VISITED)  // 如果是已经访问过的陆地，防止重复计算，直接返回0
            return 0;

        grid[x][y] = VISITED;
        int res = 0;  // 下面注释掉的写法也是可以的
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            res += dfs(grid, newX, newY);
        }
        return res;
//        return dfs(grid, x - 1, y)
//                + dfs(grid, x + 1, y)
//                + dfs(grid, x, y - 1)
//                + dfs(grid, x, y + 1);
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 题目限制只有一个岛屿，计算一个即可
                if (grid[i][j] == ISLAND)
                    return dfs(grid, i, j);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println((new Solution2()).islandPerimeter(grid));  // 16
    }
}
