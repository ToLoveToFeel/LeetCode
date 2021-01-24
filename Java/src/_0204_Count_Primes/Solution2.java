package _0204_Count_Primes;

import java.util.Arrays;

/**
 * Date: 2020/10/4 8:55
 * Content: 埃拉托色尼筛选法
 * 执行用时：19 ms, 在所有 Java 提交中击败了71.05%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了71.80%的用户
 */
public class Solution2 {

    public int countPrimes(int n) {

        n--;
        boolean[] st = new boolean[n + 5];
        Arrays.fill(st, false);
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                res++;
                for (int j = i + i; j <= n; j += i) st[j] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).countPrimes(10));  // 4
        System.out.println((new Solution2()).countPrimes(100));  // 25
    }
}
