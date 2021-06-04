package _0454_4Sum_II;

/**
 * 时间复杂度：O(n^4)
 * Time Limit Exceeded
 */
class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        for (int a : A)
            for (int b : B)
                for (int c : C)
                    for (int d : D)
                        if (a + b + c + d == 0)
                            res++;
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
        System.out.println((new Solution()).fourSumCount(A, B, C, D));
    }
}
