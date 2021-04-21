package _0003_Longest_Substring_Without_Repeating_Characters;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        char[] cs = s.toCharArray();

        int[] f = new int[128];  // 表示窗口[j, i]中字符出现的频率
        int res = 0;
        for (int i = 0, j = 0; i < cs.length; i++) {
            f[cs[i]]++;
            while (f[cs[i]] > 1) f[cs[j++]]--;
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lengthOfLongestSubstring("abcabcbb"));
    }
}
