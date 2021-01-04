package _0005_Longest_Palindromic_Substring;

/**
 * Date: 2020/8/27 20:47
 * Content: 暴力解法
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 */
class Solution {

    private boolean vaildPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;

        int begin = 0, maxLen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen && vaildPalindrome(s, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {

        String s = "aacdefcaa";
        System.out.println((new Solution()).longestPalindrome(s));
    }
}


