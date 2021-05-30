package _0400_Nth_Digit;

/**
 * Date: 2021/5/30 15:32
 * 执行用时：5 ms, 在所有 Java 提交中击败了15.96%的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了76.83%的用户
 */
public class Solution {

    public int findNthDigit(int n) {
        long k = 1, t = 9, s = 1;
        while (n > k * t) {
            n -= k * t;
            k++; t *= 10; s *= 10;
        }
        s += (n + k - 1) / k - 1;
        n = (int) (n % k == 0 ? k : n % k);
        return ("" + s).charAt(n - 1) - '0';
    }
}
