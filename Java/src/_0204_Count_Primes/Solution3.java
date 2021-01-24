package _0204_Count_Primes;

import java.util.Arrays;

/**
 * Date: 2020/10/4 8:55
 * Content: 线性筛法
 * 时间复杂度：O(n)
 * 执行用时：37 ms, 在所有 Java 提交中击败了39.25%的用户
 * 内存消耗：45.1 MB, 在所有 Java 提交中击败了7.91%的用户
 */
public class Solution3 {

    public int countPrimes(int n) {

        n--;
        boolean[] st = new boolean[n + 5];
        Arrays.fill(st, false);
        int[] p = new int[n + 5];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) p[cnt++] = i;
            for (int j = 0; p[j] <= n / i; j++) {
                st[p[j] * i] = true;
                if (i % p[j] == 0) break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).countPrimes(10));  // 4
        System.out.println((new Solution3()).countPrimes(100));  // 25
    }
}
