package _0695_Max_Area_of_Island;

import java.util.HashSet;

public class Solution {

    private int R, C;  // grid的行数，列数
    private int[][] grid;  // 岛屿

    private HashSet<Integer>[] G;  // 建模出的图G，节点数R*C，陆地之间有边
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 某个点的四个方向，上右下左
    private boolean[] visited;  // 记录节点是否访问过

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

        G = constructGraph();

        int res = 0;
        visited = new boolean[G.length];  // 默认为false

        for (int v = 0; v < G.length; v++) {
            int x = v / C, y = v % C;  // 一维坐标转化为二维坐标
            if (!visited[v] && grid[x][y] == 1)  // 只关心陆地
                res = Math.max(res, dfs(v));
        }

        return res;
    }

    // 深度优先遍历，返回某个连通分量节点数目
    private int dfs(int v){
        visited[v] = true;
        int res = 1;
        for (int w : G[v])
            if (!visited[w])
                res += dfs(w);
        return res;
    }

    private HashSet<Integer>[] constructGraph(){
        HashSet<Integer>[] g = new HashSet[R * C];
        for (int i = 0; i < g.length; i++)
            g[i] = new HashSet<>();

        for (int v = 0; v < g.length; v++){
            int x = v /C, y = v % C;  // 一维坐标转化为二维坐标
            if (1 == grid[x][y]){
                for (int d = 0; d < 4; d++){
                    int newX = x + dirs[d][0];
                    int newY = y + dirs[d][1];
                    if (inArea(newX, newY) && grid[newX][newY] == 1){
                        int next = newX * C + newY;  // 二维坐标转化为一维坐标
                        g[v].add(next);
                        g[next].add(v);
                    }
                }
            }
        }
        return g;
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

        System.out.println((new Solution()).maxAreaOfIsland(grid));
    }
}
