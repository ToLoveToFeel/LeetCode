package _0650_2_Keys_Keyboard;

/**
 * Date: 2020/12/16 20:09
 * Content: 数学解法
 * 我们可以这样考虑每一组操作：一次复制，若干次粘贴；操作的步数记为 xi
 * 对于最终生成的序列(序列长度为n)：会有若干次这样的"组操作"，x1, x2, ..., xn
 * 则有 n = x1*x2*...*xn
 * 最终的结果为对于任意的分解求最小值： min{x1+x2+...+xn}
 * <p>
 * 如果分解中存在合数，比如 xi = p*q, 其中p和q一定都大于1
 * 考虑什么情况下: x1+x2+...+xi+...+xn > x1+x2+...+p+q+...+xn
 * 即：pq>p+q    考虑 (p-1)(q-1) = pq -(p+q) + 1 >= 1, 所以在p>1, q>1的情况下pq>p+q
 * 因此，最小的结果一定是质因数分解
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.2 MB, 在所有 Java 提交中击败了81.36%的用户
 */
public class Solution {

    public int minSteps(int n) {

        int res = 0;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        if (n > 1)  // 可能还有大于sqrt(n)的素因子
            res += n;

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).minSteps(14));  // 9
        System.out.println((new Solution()).minSteps(12));  // 7
    }
}
