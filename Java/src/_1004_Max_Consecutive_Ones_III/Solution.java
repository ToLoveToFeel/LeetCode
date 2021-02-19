package _1004_Max_Consecutive_Ones_III;

/**
 * Date: 2021/2/19 9:45
 * Content: 滑动窗口：确定右边界i，找到满足条件的最左边界j
 * 执行用时：5 ms, 在所有 Java 提交中击败了17.41%的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了47.01%的用户
 */
public class Solution {

    public int longestOnes(int[] A, int K) {

        int res = 0;
        // lsum记录[0...j-1]中0的个数，rsum记录[0...i]中0的个数
        for (int i = 0, j = 0, lsum = 0, rsum = 0; i < A.length; i++) {
            rsum += 1 - A[i];
            while (rsum - lsum > K) lsum += 1 - A[j++];
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println((new Solution()).longestOnes(A, 3));  // 10
    }
}
