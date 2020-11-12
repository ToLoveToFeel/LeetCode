package _0908_Smallest_Range_I;

import java.util.Arrays;

/**
 * Date: 2020/11/12 10:16
 * Content:
 * 思路，找到最大值和最小值之间的差值 t，和2K比较大小，小于等于2K返回0，否则返回 t-2K
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了87.80%的用户
 */
public class Solution {

    public int smallestRangeI(int[] A, int K) {

        if (A.length <= 1)
            return 0;

        int max = A[0];
        int min = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
            if (A[i] < min)
                min = A[i];
        }
        int t = max - min;

        return Math.max(t - 2 * K, 0);
    }

    public static void main(String[] args) {

//        int[] A = {1};  // 0
//        int K = 0;
//        System.out.println((new Solution()).smallestRangeI(A, K));

//        int[] A = {0, 10};  // 6
//        int K = 2;
//        System.out.println((new Solution()).smallestRangeI(A, K));

//        int[] A = {1, 3, 6};  // 0
//        int K = 3;
//        System.out.println((new Solution()).smallestRangeI(A, K));

        int[] A = {2, 7, 2};  // 3
        int K = 1;
        System.out.println((new Solution()).smallestRangeI(A, K));
    }
}
