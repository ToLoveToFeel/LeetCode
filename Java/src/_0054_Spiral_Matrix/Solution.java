package _0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 时间复杂度：O(N*M)
    // 空间复杂度：O(N*M)
    public int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int N, M;  // 行数，列数

    public List<Integer> spiralOrder(int[][] matrix) {
        N = matrix.length;
        if (N == 0)
            return new ArrayList<Integer>();
        M = matrix[0].length;
        if (M == 0)
            return new ArrayList<Integer>();

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                visited[i][j] = false;

        int curd = 0, curx = 0, cury = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (res.size() < N * M){
            if (!visited[curx][cury]){
                res.add(matrix[curx][cury]);
                visited[curx][cury] = true;
            }
            int nextx = curx + d[curd][0];
            int nexty = cury + d[curd][1];
            if(inArea(nextx, nexty) && !visited[nextx][nexty]){
                curx = nextx;
                cury = nexty;
            }
            else
                curd = (curd + 1) % 4;
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println((new Solution()).spiralOrder(matrix));
    }
}
