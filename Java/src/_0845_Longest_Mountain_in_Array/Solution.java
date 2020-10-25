package _0845_Longest_Mountain_in_Array;

/**
 * Date: 2020/10/25 9:10
 * Content:
 * do by myself
 */
public class Solution {
    public int longestMountain(int[] A) {
        if (A.length <= 2)
            return 0;

        int start = 0, end = 0;  // [start...end]为“山脉”
        int res = 0;
        while (end < A.length) {
            while (end + 1 < A.length && A[end] < A[end + 1]) {
                end++;
            }
            if (start == end) {  // 说明不存在上升的峰，是下降或者平缓的峰
                start++;
                end++;
                continue;
            }
            if (end + 1 == A.length)   // 数组到达结尾，说明只存在上升的峰
                break;
            // 程序能够运行到这里说明：一定存在上升的峰，之后一定是下降或者平缓的峰
            int preEnd = end;
            while (end + 1 < A.length && A[end] > A[end + 1]) {
                end++;
            }
            if (preEnd == end) {  // 说明是平缓的峰
                start = end;
                continue;
            }

            res = Math.max(res, end - start + 1);
            start = end;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] A = {2, 1, 4, 7, 3, 2, 5};  // 5
//        int[] A = {2, 2, 2};  // 0
//        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // 0
        int[] A = {0, 2, 2};  // 0
        System.out.println((new Solution()).longestMountain(A));
    }
}
