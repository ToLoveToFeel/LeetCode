package _0867_Transpose_Matrix;

import _0000_study._common.Output;

/**
 * Date: 2020/8/28 20:58
 * Content:
 */
class Solution {

    public int[][] transpose(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[j][i] = matrix[i][j];
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
        };
        Output.OutputBasicArray2D((new Solution()).transpose(matrix));
    }
}
