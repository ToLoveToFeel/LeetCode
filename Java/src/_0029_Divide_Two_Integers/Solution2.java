package _0029_Divide_Two_Integers;

/**
 * Date: 2020/10/16 15:46
 * Content:
 * 改进 Solution, 使用二分搜索
 * 双百
 */
public class Solution2 {
    // 返回正整数除法 a / b , 并且 a 和 b 均不为 0
    private int negativeDivide(long a, long b) {
        if (a > b)
            return 0;
        int count = 1;
        long sum = b;
        while (sum + sum >= a) {
            sum += sum;
            count += count;
        }

        return count + negativeDivide(a - sum, b);
    }

    public int divide(int dividend, int divisor) {
        // 特殊情况处理
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;
        if (dividend == 0)
            return 0;

        int sign = ((dividend ^ divisor) >>> 31);  // 结果为 1 的话，说明异号；结果为 0 的话，说明同号；

        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        int res = negativeDivide(a, b);
        return sign == 1 ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).divide(10, 3));
        System.out.println((new Solution2()).divide(7, -3));
        System.out.println((new Solution2()).divide(Integer.MIN_VALUE, 2));
    }
}
