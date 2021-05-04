package _0214_Shortest_Palindrome;

/**
 * Date: 2021/5/4 11:16
 */
public class Solution {

    public String shortestPalindrome(String s) {

        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        s = ' ' + s + '#' + t;
        char[] cs = s.toCharArray();
        int[] ne = new int[2 * n + 2];
        for (int i = 2, j = 0; i <= 2 * n + 1; i++) {
            while (j != 0 && cs[i] != cs[j + 1]) j = ne[j];
            if (cs[i] == cs[j + 1]) j++;
            ne[i] = j;
        }
        int len = ne[2 * n + 1];
        String left = s.substring(1, 1 + len), right = s.substring(1 + len, n + 1);
        return new StringBuilder(right).reverse() + left + right;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).shortestPalindrome("aacecaaa"));  // aaacecaaa
        System.out.println((new Solution()).shortestPalindrome("abcd"));  // dcbabcd
    }
}
