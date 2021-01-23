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

        if (a > b) return 0;
        int count = 1;
        long sum = b;
        while (sum + sum >= a) {
            sum += sum;
            count += count;
        }

        return count + negativeDivide(a - sum, b);
    }

    public int divide(int a, int b) {
        // 特殊情况处理
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        if (b == 1) return a;
        if (b == -1) return -a;
        if (a == 0) return 0;

        int sign = ((a ^ b) >>> 31);  // 结果为 1 的话，说明异号；结果为 0 的话，说明同号；

        int x = a > 0 ? -a : a;
        int y = b > 0 ? -b : b;
        int res = negativeDivide(x, y);
        return sign == 1 ? -res : res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).divide(10, 3));
        System.out.println((new Solution2()).divide(7, -3));
        System.out.println((new Solution2()).divide(Integer.MIN_VALUE, 2));
    }
}
