package _0059_Spiral_Matrix_II;

import _0000_study._common.Output;

/**
 * Date: 2021/1/23 15:23
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.9 MB, 在所有 Java 提交中击败了5.20%的用户
 */
public class Solution {

    public int[][] generateMatrix(int n) {

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int[][] res = new int[n][n];
        int x = 0, y = 0, d = 1;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] != 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] res = (new Solution()).generateMatrix(3);
        Output.OutputBasicArray2D(res);
    }
}
