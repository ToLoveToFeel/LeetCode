package _0995_Minimum_Number_of_K_Consecutive_Bit_Flips;

import java.util.Arrays;

/**
 * Date: 2021/2/18 9:45
 * Content: 考点：递推、差分
 * 执行用时：8 ms, 在所有 Java 提交中击败了78.26%的用户
 * 内存消耗：46.9 MB, 在所有 Java 提交中击败了11.25%的用户
 */
public class Solution {

    public int minKBitFlips(int[] A, int K) {

        int n = A.length;
        int[] B = new int[n + 1];  // 表示翻转次数的差分数组，B[0]+...+B[i]表示A[i]的翻转次数
        Arrays.fill(B, 0);
        int res = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += B[i];
            if ((A[i] + sum) % 2 == 0) {
                if (i + K > n) return -1;  // i + K - 1 > n - 1 剩余元素不够翻转
                res++;
                sum++;  // B[i] += 1 会导致sum++
                B[i + K]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {0, 1, 0};
        System.out.println((new Solution()).minKBitFlips(A, 1));  // 2
    }
}
