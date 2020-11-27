package _0454_4Sum_II;

/**
 * 时间复杂度：O(n^4)
 * Time Limit Exceeded
 */
class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0)
                            res++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println((new Solution()).fourSumCount(A, B, C, D));
    }
}
