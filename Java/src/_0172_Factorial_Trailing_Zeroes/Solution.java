package _0172_Factorial_Trailing_Zeroes;

/**
 * Date: 2021/6/29 14:37
 */
public class Solution {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).trailingZeroes(3));  // 0
        System.out.println((new Solution()).trailingZeroes(5));  // 1
    }
}
