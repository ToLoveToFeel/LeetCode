package _0009_Palindrome_Number;

/**
 * Date: 2020/8/26 22:03
 * Content:
 */
public class Solution3 {

    public boolean isPalindrome(int x) {
        // 当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是 0，只有 0 满足这一属性
        if ((x < 0) || (x % 10 == 0 && x != 0))
            return false;

        // 翻转一半数字
        int reverseNum = 0;
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }

    public static void main(String[] args) {

        int x = 121;
        System.out.println((new Solution3()).isPalindrome(x));
    }
}
