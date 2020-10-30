package _0463_Island_Perimeter;

/**
 * Date: 2020/10/30 10:07
 * Content:
 * 暴力解法
 * 执行用时：9 ms, 在所有 Java 提交中击败了56.99%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了72.46%的用户
 */
public class Solution {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    int m, n;  // 行数，列数

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        if (m == 0)
            return 0;
        n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (grid[i][j] == 1) {  // 如果当前是岛屿
                    for (int k = 0; k < 4; k++) {  // 考察岛屿的四个临边
                        int newX = i + d[k][0];
                        int newY = j + d[k][1];
                        if (!inArea(newX, newY))  // 如果临边是边界,边长加一
                            count++;
                        else if (grid[newX][newY] == 0)  // 如果临边不是边界，并且临边是水域，边长加一
                            count++;
                    }
                }
                res += count;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println((new Solution()).islandPerimeter(grid));  // 16
    }
}
