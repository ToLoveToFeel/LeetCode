package _0832_Flipping_an_Image;

import _0000_study._common.Output;

/**
 * Date: 2021/2/24 9:49
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了75.04%的用户
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {

        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = 1 - A[i][n - 1 - j];
        return res;
    }

    public static void main(String[] args) {

        int[][] A = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        Output.OutputBasicArray2D((new Solution()).flipAndInvertImage(A));
    }
}
