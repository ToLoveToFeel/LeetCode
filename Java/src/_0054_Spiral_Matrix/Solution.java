package _0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度：O(N*M)
 * 空间复杂度：O(N*M)
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了8.33%的用户
 */
class Solution {

    public int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int N, M;  // 行数，列数

    public List<Integer> spiralOrder(int[][] matrix) {

        N = matrix.length;
        if (N == 0) return new ArrayList<>();
        M = matrix[0].length;
        if (M == 0) return new ArrayList<>();

        boolean[][] st = new boolean[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(st[i], false);

        ArrayList<Integer> res = new ArrayList<>();
        int dir = 0, x = 0, y = 0;
        while (res.size() < N * M) {
            if (!st[x][y]) {
                res.add(matrix[x][y]);
                st[x][y] = true;
            }
            int a = x + d[dir][0], b = y + d[dir][1];
            if (a >= 0 && a < N && b >= 0 && b < M && !st[a][b]) {
                x = a;
                y = b;
            } else dir = (dir + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println((new Solution()).spiralOrder(matrix));
    }
}
