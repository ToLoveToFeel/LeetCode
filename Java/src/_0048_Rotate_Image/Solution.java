package _0048_Rotate_Image;

public class Solution {
    // 1、这道题比较巧妙，顺时针转90度可以转换为 先上下翻转，再对角线翻转;
    // 2、同理：逆时针转90度可以转换为 先左右翻转，再对角线翻转.
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }

        for (int i = 0; i < matrix.length; i++)
            for (int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
}
