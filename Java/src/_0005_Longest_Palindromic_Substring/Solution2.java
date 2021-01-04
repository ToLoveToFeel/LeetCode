package _0005_Longest_Palindromic_Substring;

/**
 * Date: 2020/8/27 20:47
 * Content: 中心扩散法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution2 {

    private int expand(String s, int left, int right) {

        // left == right，回文中心是一个字符
        // left + 1 == right，回文中心是两个字符
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }

    // 中心扩散法
    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;

        int begin = 0, maxLen = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int curMaxLen = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {

        String s = "aacdefcaa";
        System.out.println((new Solution2()).longestPalindrome(s));
    }
}


