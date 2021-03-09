package _0680_Valid_Palindrome_II;

/**
 * Created by WXX on 2021/3/9 9:25
 * 执行用时：10 ms, 在所有 Java 提交中击败了33.04%的用户
 * 内存消耗：39.3 MB, 在所有 Java 提交中击败了5.19%的用户
 */
public class Solution {

    boolean check(char[] a, int i, int j) {
        while (i < j) {
            if (a[i] != a[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; i++, j--)
            if (a[i] != a[j]) {
                return check(a, i + 1, j) || check(a, i, j - 1);
            }
        return true;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).validPalindrome("aba"));  // true
        System.out.println((new Solution()).validPalindrome("abca"));  // true
    }
}
