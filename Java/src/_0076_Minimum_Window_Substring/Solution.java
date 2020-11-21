package _0076_Minimum_Window_Substring;

/**
 * 解法：滑动窗口
 * (1) 统计 t 中所有字符出现的次数，存入 tFreq 中
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

public class Solution {

    // 滑动窗口
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        int[] tFreq = new int[256];  // 初始化默认为0
        // 统计t中字符个数
        for (int i = 0; i < t.length(); i++)
            tFreq[t.charAt(i)]++;

        int[] sFreq = new int[256];  // 统计s[l...r]中字符出现的次数
        // 统计s中出现t中字符的个数, 如果某字母 在s中出现的次数 超过 t中出现的次数, sCount不增加
        // 例如 s = "aaaaaab", t = "ab"
        int sCount = 0;

        int minLength = s.length() + 1;  // 统计最短的满足条件的子串
        int startIndex = -1;  // 子串起始位置

        int l = 0, r = -1;  // [l...r]滑动窗口
        int sLength = s.length();
        int tLength = t.length();
        // 下标：l + t - 1 <= s - 1  ==>  l + t - 1 < s  ==> l < s - t + 1
        while (l < sLength - tLength + 1) {

            if (r + 1 < sLength && sCount < tLength) {
                sFreq[s.charAt(r + 1)]++;
                if (sFreq[s.charAt(r + 1)] <= tFreq[s.charAt(r + 1)])  // s[r+1]是t中的未统计的字符
                    sCount++;
                r++;
            } else {
                assert sCount <= tLength;
                if (sCount == tLength && r - l + 1 < minLength) {
                    minLength = r - l + 1;  // 更新最小长度
                    startIndex = l;
                }
                sFreq[s.charAt(l)]--;
                if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)])   // s[l]是t中的未统计的字符
                    sCount--;
                l++;
            }
        }

        if (startIndex != -1)
            return s.substring(startIndex, startIndex + minLength);

        return "";
    }

    public static void main(String[] args) {

//        System.out.println((new Solution()).minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println((new Solution()).minWindow("a", "aa"));
//        System.out.println((new Solution()).minWindow("aa", "aa"));
//        System.out.println((new Solution()).minWindow("bba", "ab"));
        System.out.println((new Solution()).minWindow("aaaaaab", "ab"));
    }
}
