package _0125_Valid_Palindrome;

public class Solution3 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        StringBuilder bld = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", ""));
        return bld.toString().equalsIgnoreCase(bld.reverse().toString());
    }


    public static void main(String[] args) {
        String s = ".,";

        System.out.println((new Solution3()).isPalindrome(s));
    }
}
