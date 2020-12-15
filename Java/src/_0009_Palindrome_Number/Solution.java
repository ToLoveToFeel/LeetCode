package _0009_Palindrome_Number;

/**
 * Date: 2020/8/26 22:03
 * Content:
 */
public class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;
        String s = x + "";

        int left = 0;
        int right = s.length() - 1;
        while (right > left) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int x = 121;
        System.out.println((new Solution()).isPalindrome(x));
    }
}
