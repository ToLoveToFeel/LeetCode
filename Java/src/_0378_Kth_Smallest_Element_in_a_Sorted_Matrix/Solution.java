package _0378_Kth_Smallest_Element_in_a_Sorted_Matrix;

/**
 * Date: 2021/5/29 16:03
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (int) ((long) l + r >> 1);
            int i = matrix[0].length - 1, cnt = 0;
            for (int j = 0; j < matrix.length; j++) {
                while (i >= 0 && matrix[j][i] > mid) i--;
                cnt += i + 1;
            }
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15},
        };
        System.out.println((new Solution()).kthSmallest(matrix, 8));  // 13
    }
}
