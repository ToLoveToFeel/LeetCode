package _0052_N_Queens_II;

import java.util.List;

/**
 * Date: 2020/9/3 15:15
 * Content:
 */
public class Solution {
    int totalNum;
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    private void totalNQueens(int n, int index) {
        if (index == n) {
            totalNum++;
            return;
        }

        for (int j = 0; j < n; j++)
            if (!col[j] && !dia1[index + j] && !dia2[index - j + n - 1]) {
                col[j] = true;
                dia1[index + j] = true;
                dia2[index - j + n - 1] = true;
                totalNQueens(n, index + 1);
                col[j] = false;
                dia1[index + j] = false;
                dia2[index - j + n - 1] = false;
            }
    }

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        totalNQueens(n, 0);

        return totalNum;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println((new Solution()).totalNQueens(n));
    }
}
