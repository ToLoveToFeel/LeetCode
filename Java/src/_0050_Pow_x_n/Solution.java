package _0050_Pow_x_n;

public class Solution {

    public double myPow(double x, int n) {
        return pow(x, n);
    }

    private double pow(double x, long n) {

        if (n < 0) {
            x = 1.0 / x;
            n *= -1;
        } else if (n == 0) return 1;
        else if (n == 1) return x;

        if (n % 2 == 0) {
            double half = pow(x, n / 2);
            return half * half;
        } else return x * pow(x, n - 1);  // n % 2 == 1
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).myPow(2.0, 10));
        System.out.println((new Solution()).myPow(2.1, 3));
        System.out.println((new Solution()).myPow(2.0, -2));
        System.out.println((new Solution()).myPow(2.0, -2147483648));
    }
}
