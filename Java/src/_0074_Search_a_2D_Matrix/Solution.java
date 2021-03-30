package _0074_Search_a_2D_Matrix;

/**
 * Created by WXX on 2021/3/30 9:05
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了93.94%的用户
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }
        return matrix[r / m][r % m] == target;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println((new Solution()).searchMatrix(matrix, 3));  // true
        System.out.println((new Solution()).searchMatrix(matrix, 13));  // false
    }
}
