package _1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int R, C;  // grid的行数，列数

    public int shortestPathBinaryMatrix(int[][] grid) {

        R = grid.length;
        C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int[][] dis = new int[R][C];

        if (grid[0][0] == 1)
            return -1;
        if (R == 1 && C == 1)
            return 1;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int curX = cur / C, curY = cur % C;  // 一维坐标转二维

            for (int newX = curX - 1; newX <= curX + 1; newX++)
                for (int newY = curY - 1; newY <= curY + 1; newY++)
                    if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.add(newX * C + newY);
                        visited[newX][newY] = true;
                        dis[newX][newY] = dis[curX][curY] + 1;

                        if (newX == R - 1 && newY == C - 1)
                            return dis[newX][newY];
                    }
        }
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        System.out.println((new Solution()).shortestPathBinaryMatrix(grid));
    }
}
