package _0718_Maximum_Length_of_Repeated_Subarray;

/**
 * Date: 2020/8/27 11:24
 * Content:
 * 时间复杂度： O(N×M)
 * 空间复杂度： O(N×M)
 */
class Solution {
    // 动态规划
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int max = 0;
        // 填充第一行
        for (int j = 0; j < B.length; j++) {
            if (A[0] == B[j])
                dp[0][j] = 1;
        }
        // 填充第二行
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0])
                dp[i][0] = 1;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println((new Solution()).findLength(A, B));
    }
}
