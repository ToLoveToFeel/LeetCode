package _0240_Search_a_2D_Matrix_II;

/**
 * Date: 2020/10/13 10:03
 * Content: 二分法
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        // 寻找第一行中最后一个小于 target 的数据的索引
        int indexJ = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] > target) {
                indexJ = j - 1;
                break;
            }
        }
        if (indexJ == Integer.MIN_VALUE) indexJ = matrix[0].length - 1;

        // 寻找第一列中最后一个小于 target 的数据的索引
        int indexI = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                indexI = i - 1;
                break;
            }
        }
        if (indexI == Integer.MIN_VALUE) indexI = matrix.length - 1;

        // 在 matrix[indexI][indexJ] 中寻找 target
        if (indexI < indexJ) {  // 按照行对每一行进行二分查找
            for (int i = 0; i <= indexI; i++) {
                int l = 0, r = indexJ;  // 在 matrix[i][l...r] 中搜索 target
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    if (target == matrix[i][mid]) return true;

                    if (target > matrix[i][mid]) l = mid + 1;
                    else r = mid - 1;
                }
            }
        } else {  // 按照列对每一行进行二分查找
            for (int j = 0; j <= indexJ; j++) {
                int l = 0, r = indexI;  // 在 matrix[l...r][j] 中搜索 target
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    if (target == matrix[mid][j]) return true;

                    if (target > matrix[mid][j]) l = mid + 1;
                    else r = mid - 1;
                }
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

//        int[][] matrix = {
//                {-5}
//        };
//        int target = -5;

//        int[][] matrix = {
//                {-1, 3}
//        };
//        int target = 3;

        System.out.println((new Solution2()).searchMatrix(matrix, target));
    }
}
