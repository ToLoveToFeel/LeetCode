package _1337_The_K_Weakest_Rows_in_a_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/8/1 10:13
 * Content:
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> row = new ArrayList<>();  // (每行军人数, 行号)
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < m; j++) s += mat[i][j];
            row.add(new int[]{s, i});
        }
        row.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = row.get(i)[1];
        return res;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString((new Solution()).kWeakestRows(mat, 3)));  // [2, 0, 3]
    }
}
