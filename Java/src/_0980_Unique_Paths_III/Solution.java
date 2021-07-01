package _0980_Unique_Paths_III;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了21.70%的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了61.60%的用户
 */
public class Solution {

    private int[][] grid;
    private int n, m;
    private boolean[][] st;
    private int start, end;

    private final static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        st = new boolean[n][m];

        int cnt = n * m;  // 初始表示多少个可以走的格子数目
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) start = i * m + j;
                else if (grid[i][j] == 2) end = i * m + j;
                else if (grid[i][j] == -1) cnt--;

        return dfs(start, cnt);
    }

    private int dfs(int u, int cnt) {

        int x = u / m, y = u % m;
        if (--cnt == 0 && u == end) {
            st[x][y] = false;
            return 1;
        }

        int res = 0;
        st[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int a = x + dirs[d][0], b = y + dirs[d][1];
            if (a >= 0 && a < n && b >= 0 && b < m && grid[a][b] != -1 && !st[a][b])
                res += dfs(a * m + b, cnt);
        }
        st[x][y] = false;

        return res;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };
        System.out.println((new Solution()).uniquePathsIII(grid));  // 4
    }
}
