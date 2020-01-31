package _0980_Unique_Paths_III;

public class Solution {
    // 图论问题，哈密尔顿路径问题
    private int[][] grid;
    private int R, C;
    private boolean[][] visited;
    private int start, end;

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        this.R = grid.length;
        this.C = grid[0].length;
        visited = new boolean[R][C];
        int left = R * C;  // 记录走过的节点数目

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == 1){
                    start = i * C + j;  // 二维数据压缩成一维数据
                    grid[i][j] = 0;
                }
                else if (grid[i][j] == 2){
                    end = i * C + j;
                    grid[i][j] = 0;
                }
                else if (grid[i][j] == -1)
                    left --;
        return dfs(start, left);
    }

    private int dfs(int v, int left){
        int x = v / C, y = v % C;
        visited[x][y] = true;
        left--;
        if (left == 0 && v == end){
            visited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++){
            int newX = x + dirs[d][0], newY = y + dirs[d][1];
            if (inArea(newX, newY) && grid[newX][newY] == 0 && !visited[newX][newY])
                res += dfs(newX * C + newY, left);
        }

        visited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,0,2}};
        System.out.println((new Solution()).uniquePathsIII(grid));
    }
}
