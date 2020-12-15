package _0125_Valid_Palindrome;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution3 {

    public boolean isPalindrome(String s) {

        if (s.isEmpty())
            return true;

        StringBuilder sb = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", ""));
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }


    public static void main(String[] args) {

        String s = ".,";
        System.out.println((new Solution3()).isPalindrome(s));
    }
}
