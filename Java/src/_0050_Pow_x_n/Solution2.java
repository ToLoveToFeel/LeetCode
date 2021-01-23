package _0050_Pow_x_n;

public class Solution2 {

    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1.0 / x;
            if (n != Integer.MIN_VALUE) n *= -1;  // 对int最小值做特殊处理
        } else if (n == 0) return 1;
        else if (n == 1) return x;

        if (n == Integer.MIN_VALUE) {  // 对int最小值做特殊处理
            n++;
            n *= -1;
            return x * myPow(x, n);
        }

        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        } else return x * myPow(x, n - 1);  // n % 2 == 1
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).myPow(2.0, 10));
        System.out.println((new Solution2()).myPow(2.1, 3));
        System.out.println((new Solution2()).myPow(2.0, -2));
        System.out.println((new Solution2()).myPow(2.0, -2147483648));
    }
}
