package _0000_study._leetcode._interviewquestions._01_08_Zero_Matrix;

import java.util.HashSet;

/**
 * Date: 2020/9/18 16:18
 * Content:
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        // 第一步：记录数值为 0 的行号 和 列号
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        // 第二步：将 0 所在的行列数据清零
        for (Integer integer : rowSet) {
            for (int j = 0; j < n; j++)
                matrix[integer][j] = 0;
        }
        for (Integer integer : columnSet) {
            for (int i = 0; i < m; i++)
                matrix[i][integer] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        (new Solution()).setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
