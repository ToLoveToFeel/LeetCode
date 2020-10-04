package _0204_Count_Primes;

import java.util.Arrays;

/**
 * Date: 2020/10/4 8:55
 * Content:
 * Sieve of Eratosthenes: 埃拉托色尼筛选法
 * https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
 * https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-bao-li-fa-ji-you-hua-shai-fa-ji-you/
 */
public class Solution2 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        int max = (int) Math.sqrt(n);
        for (int num = 2; num <= max; num++) {
            if (isPrime[num]) {
                // num 的倍数不可能是素数了
                for (int i = num * num; i < n; i += num) {
                    isPrime[i] = false;
                }
            }
        }
        
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).countPrimes(10));
        System.out.println((new Solution2()).countPrimes(100));
    }
}
