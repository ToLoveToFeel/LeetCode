package _0204_Count_Primes;

import java.util.Arrays;

/**
 * Date: 2020/10/4 8:55
 * Content:
 * 基础解法
 */
public class Solution {
    // 判断 num 是否为素数
    private boolean isPrime(int num) {
        int maxDivisor = (int) Math.sqrt(num);
        for (int i = 2; i <= maxDivisor; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;

        int res = 0;
        for (int num = 2; num < n; num++) {
            if (isPrime(num))
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).countPrimes(10));
        System.out.println((new Solution()).countPrimes(100));
    }
}
