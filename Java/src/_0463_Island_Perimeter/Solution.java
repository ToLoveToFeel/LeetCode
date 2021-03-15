package _0463_Island_Perimeter;

/**
 * Date: 2020/10/30 10:07
 * Content: Floodfill
 * 执行用时：11 ms, 在所有 Java 提交中击败了32.41%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了88.92%的用户
 */
public class Solution {

    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};  // 上右下左

    public int islandPerimeter(int[][] grid) {

        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    for (int k = 0; k < 4; k++) {
                        int a = i + dx[k], b = j + dy[k];
                        if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length) res++;
                        else if (grid[a][b] == 0) res++;
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
