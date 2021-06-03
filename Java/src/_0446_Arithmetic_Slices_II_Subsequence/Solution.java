package _0446_Arithmetic_Slices_II_Subsequence;

import java.util.HashMap;

/**
 * Date: 2021/6/3 10:37
 * 执行用时：295 ms, 在所有 Java 提交中击败了16.18%的用户
 * 内存消耗：97.7 MB, 在所有 Java 提交中击败了16.91%的用户
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] a) {
        int n = a.length;
        HashMap<Long, Integer>[] f = new HashMap[n];
        for (int i = 0; i < n; i++) f[i] = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int k = 0; k < i; k++) {
                long j = (long)a[i] - a[k];
                int t = f[k].getOrDefault(j, 0);
                res += t;
                f[i].put(j, f[i].getOrDefault(j, 0) + t + 1);
            }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));  // 7
        System.out.println((new Solution()).numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));  // 16
    }
}
