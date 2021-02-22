package _0766_Toeplitz_Matrix;

/**
 * Date: 2021/2/22 8:59
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了25.52%的用户
 */
public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println((new Solution()).isToeplitzMatrix(matrix));  // true
    }
}
