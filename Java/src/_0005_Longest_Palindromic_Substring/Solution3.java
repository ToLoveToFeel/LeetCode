package _0005_Longest_Palindromic_Substring;

/**
 * Date: 2020/8/27 20:47
 * Content:
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
class Solution3 {
    // 动态规划
    // 状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j -1])
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "aacdefcaa";
        System.out.println((new Solution3()).longestPalindrome(s));
    }
}


