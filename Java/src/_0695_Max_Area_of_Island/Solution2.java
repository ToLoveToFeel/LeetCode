package _0695_Max_Area_of_Island;

public class Solution2 {

    private int R, C;  // grid的行数，列数
    private int[][] grid;  // 岛屿

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左
    private boolean[][] visited;  // 记录节点是否访问过

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        R = grid.length;
        if (0 == R)
            return 0;
        C = grid[0].length;
        if (0 == C)
            return 0;

        this.grid = grid;

        int res = 0;
        visited = new boolean[R][C];  // 默认为false

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (!visited[i][j] && grid[i][j] ==1)
                    res = Math.max(res, dfs(i, j));

        return res;
    }

    // 深度优先遍历，返回某个陆地大小
    private int dfs(int x, int y){
        visited[x][y] = true;
        int res = 1;
        for (int d = 0; d < 4; d++){
            int newX = x + dirs[d][0], newY = y + dirs[d][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1)
                res += dfs(newX, newY);
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println((new Solution2()).maxAreaOfIsland(grid));
    }
}
