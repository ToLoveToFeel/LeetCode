package _0200_Number_of_Islands;

/**
 * Date: 2020/9/3 16:21
 * Content: 经典的 floodfill 算法
 * 执行用时：2 ms, 在所有 Java 提交中击败了92.58%的用户
 * 内存消耗：40.7 MB, 在所有 Java 提交中击败了84.35%的用户
 */
class Solution {

    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    int n, m;  // 行数，列数
    char[][] g;
    boolean[][] st;

    // 从grid[x][y]的位置开始(该位置要求为'1'，即陆地)，进行 floodfill
    private void dfs(int x, int y) {
        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + d[i][0], b = y + d[i][1];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b] && g[a][b] == '1')
                dfs(a, b);
        }
    }

    public int numIslands(char[][] grid) {

        g = grid;
        n = g.length;
        if (n == 0) return 0;
        m = g[0].length;
        st = new boolean[n][m];

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1' && !st[i][j]) {
                    res++;
                    dfs(i, j);
                }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new Solution()).numIslands(grid));
    }
}
