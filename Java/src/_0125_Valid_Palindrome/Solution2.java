package _0125_Valid_Palindrome;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();  // 全部转化为小写字母

        int i = next_alpha_numeric(s, 0);
        int j = prev_alpha_numeric(s, s.length() - 1);
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i = next_alpha_numeric(s, i + 1);
            j = prev_alpha_numeric(s, j - 1);
        }

        return true;
    }

    private int next_alpha_numeric(String s, int index) {

        for (int i = index; i < s.length(); i++)
            if (isValidCharacter(s.charAt(i)))
                return i;

        return s.length();
    }

    private int prev_alpha_numeric(String s, int index) {

        for (int i = index; i >= 0; i--)
            if (isValidCharacter(s.charAt(i)))
                return i;
        return -1;
    }

    private boolean isValidCharacter(Character c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {

        String s = ".,";
        System.out.println((new Solution2()).isPalindrome(s));
    }
}
