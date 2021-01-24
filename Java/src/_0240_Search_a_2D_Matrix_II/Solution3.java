package _0240_Search_a_2D_Matrix_II;

/**
 * Date: 2020/10/13 10:03
 * Content:
 */
public class Solution3 {

    public boolean searchMatrix(int[][] m, int target) {

        if (m.length == 0) return false;
        if (m[0].length == 0) return false;

        int rowSize = m.length, columnSize = m[0].length;
        int i = 0, j = columnSize - 1;  // 从矩阵的右上角开始匹配，如果匹配到了，返回true
        while (i < rowSize && j >= 0) {
            if (m[i][j] == target) return true;
            else if (m[i][j] < target) i++;  // 如果值比target小，则说明这一行都比target小，row往下移一行
            else j--;  // 如果值比target大，说明这一列都比target大，column往左移一行
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
