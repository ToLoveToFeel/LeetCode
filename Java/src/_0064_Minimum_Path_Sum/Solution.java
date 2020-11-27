package _0064_Minimum_Path_Sum;

public class Solution {
    /*
    递归：自顶向下
        1.假如我们就在最右下角的格子(也可以想象成网格只有一个格子)，那么最短路径和就是格子中的值；
        2.然后假如我们在最后一行的格子中，假如是grid[grid.length][j]，那么从这个点出发到最右下角的
          最小路径和就是本身加上它左边的格子到最右下角的最小路径和。最后一列和最后一行是同理的。
        3.一个普通的位置，它到最右下角的最小路径和是多少呢，是它右边一个位置和它下面一个位置的最小
          路径和中最小的那个加上它自己格子的值。
     */
    private int n;
    private int m;

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        n = grid.length;
        m = grid[0].length;

        return rec(grid, 0, 0);
    }

    // 返回从(i,j)出发到右下格的最短距离
    private int rec(int[][] grid, int i, int j) {

        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        if (i == n - 1)  // 在最后一行
            return grid[i][j] + rec(grid, i, j + 1);
        if (j == m - 1)  //最后一列
            return grid[i][j] + rec(grid, i + 1, j);

        return grid[i][j] + Math.min(rec(grid, i + 1, j), rec(grid, i, j + 1));
    }

    public static void main(String[] args) {

        // 四种错误
        // int[][] grid = null;  // grid == null
        // int[][] grid = {};  // grid.length == 0
        // int[][] grid = {null};  // grid[0] == null
        // int[][] grid = {{}};  // grid[0].length == 0
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println((new Solution()).minPathSum(grid));
    }
}
