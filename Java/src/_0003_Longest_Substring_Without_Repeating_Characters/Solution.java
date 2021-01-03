package _0003_Longest_Substring_Without_Repeating_Characters;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0, r = -1;  // 滑动窗口[l...r]
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) freq[s.charAt(++r)]++;
            else freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lengthOfLongestSubstring("abcabcbb"));
    }
}
