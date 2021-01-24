package _0240_Search_a_2D_Matrix_II;

/**
 * Date: 2020/10/13 10:03
 * Content: 暴力解法：O(m*n)
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target == matrix[i][j])
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println((new Solution()).searchMatrix(matrix, target));
    }
}
