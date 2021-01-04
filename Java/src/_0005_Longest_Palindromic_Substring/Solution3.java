package _0005_Longest_Palindromic_Substring;

/**
 * Date: 2020/8/27 20:47
 * Content: 动态规划
 * 状态：dp[i][j]：代表s[i...j]是否是回文串
 * 状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])
 * j - i < 3 是因为[i + 1, j - 1]不构成区间，即(j - 1) - (i + 1) + 1 < 2 ==> j - i < 3
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
class Solution3 {

    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;

        int begin = 0, maxLen = 1;
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


