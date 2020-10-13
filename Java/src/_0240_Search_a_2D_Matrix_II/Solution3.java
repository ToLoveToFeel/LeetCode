package _0240_Search_a_2D_Matrix_II;

/**
 * Date: 2020/10/13 10:03
 * Content:
 */
public class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;

        int rowSize = matrix.length, columnSize = matrix[0].length;
        int row = 0, column = columnSize - 1;  // 从矩阵的右上角开始匹配，如果匹配到了，返回true
        while (row < rowSize && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] < target)  // 如果值比target小，则说明这一行都比target小，row往下移一行
                row++;
            else  // 如果值比target大，说明这一列都比target大，column往左移一行
                column--;
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

//        int[][] matrix = {
//                {-5}
//        };
//        int target = -5;

//        int[][] matrix = {
//                {-1, 3}
//        };
//        int target = 3;

        System.out.println((new Solution3()).searchMatrix(matrix, target));
    }
}
