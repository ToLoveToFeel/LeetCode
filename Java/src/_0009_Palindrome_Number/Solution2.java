package _0009_Palindrome_Number;

/**
 * Date: 2020/8/26 22:03
 * Content:
 */
public class Solution2 {

    // 第七题：求一个数字的逆
    private int reverse(int x) {

        int onetenthMax = Integer.MAX_VALUE / 10;
        int remainderOfMax = Integer.MAX_VALUE % 10;
        int onetenthMin = Integer.MIN_VALUE / 10;
        int remainderOfMin = Integer.MIN_VALUE % 10;
        int res = 0;

        while (x != 0) {
            int temp = x % 10;
            if (res > onetenthMax || (res == onetenthMax && temp > remainderOfMax))
                return 0;
            if (res < onetenthMin || (res == onetenthMin && temp < remainderOfMin))
                return 0;
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }

    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;
        return x == reverse(x);
    }

    public static void main(String[] args) {

        int x = 121;
        System.out.println((new Solution2()).isPalindrome(x));
    }
}
