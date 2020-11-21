package _0718_Maximum_Length_of_Repeated_Subarray;

/**
 * Date: 2020/8/27 11:24
 * Content:
 * 时间复杂度： O(N×M)
 * 空间复杂度： O(N×M)
 */
class Solution2 {

    private int maxLength(int[] A, int[] B, int startA, int startB, int length) {
        int res = 0;  // 记录最长子串
        int k = 0;  // 记录每段最长子串
        for (int i = 0; i < length; i++) {
            if (A[startA + i] == B[startB + i]) {
                k++;
            } else {
                k = 0;
            }
            res = Math.max(res, k);
        }
        return res;
    }

    // 滑动窗口法
    public int findLength(int[] A, int[] B) {

        int m = A.length, n = B.length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int length = Math.min(m - i, n);
            int maxLen = maxLength(A, B, i, 0, length);
            res = Math.max(res, maxLen);
        }
        for (int i = 0; i < n; i++) {
            int length = Math.min(m, n-i);
            int maxLen = maxLength(A, B, 0, i, length);
            res = Math.max(res, maxLen);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println((new Solution2()).findLength(A, B));
    }
}
