package _0069_Sqrt_x;

/**
 * Date: 2020/9/10 15:16
 * Content:
 * 牛顿迭代法
 * https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
 */
public class Solution3 {
    public int mySqrt(int x) {
        double x0 = 1;
        double pre;

        while (true) {
            pre = x0;
            x0 = (x0 + x / x0) / 2;
            if (Math.abs(x0 - pre) < 1e-6)
                return (int) x0;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution3()).mySqrt(7));
        System.out.println((new Solution3()).mySqrt(2147395600));
    }
}
