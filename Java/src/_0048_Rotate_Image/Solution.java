package _0048_Rotate_Image;

import _0000_study._common.Output;

/**
 * 1、这道题比较巧妙，顺时针转90度可以转换为 先上下翻转，再对角线翻转;
 * 2、同理：逆时针转90度可以转换为 先左右翻转，再对角线翻转.
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了76.44%的用户
 */
public class Solution {

    public void rotate(int[][] matrix) {

        // 上下翻转
        for (int i = 0; i < matrix.length / 2; i++) {

            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }

        // 沿着对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        (new Solution()).rotate(matrix);

        // 输出结果
        Output.OutputBasicArray2D(matrix);
    }
}
