package _0076_Minimum_Window_Substring;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 使用一个字符串filtered_s，其中只包含s中那些t中含有的字符
 * 当t的长度远远小于s的长度时，效果比较好
 */
public class Solution2 {

    public String minWindow(String s, String t) {

        HashSet<Character> t_set = new HashSet<>();
        int[] tFreq = new int[256];
        for (int i = 0; i < t.length(); i++) {
            t_set.add(t.charAt(i));
            tFreq[t.charAt(i)]++;
        }

        StringBuilder filtered_s = new StringBuilder();
        ArrayList<Integer> pos = new ArrayList<>();  // 记录 filtered_s 中各字符在 s 中的位置
        for (int i = 0; i < s.length(); i++) {
            if (t_set.contains(s.charAt(i))) {
                filtered_s.append(s.charAt(i));
                pos.add(i);
            }
        }

        int[] sFreq = new int[256];  // 统计s[l...r]中字符出现的次数
        // 统计s中出现t中字符的个数, 如果某字母 在s中出现的次数 超过 t中出现的次数, sCount不增加
        // 例如 s = "aaaaaab", t = "ab"
        int sCount = 0;

        int minLength = s.length() + 1;  // 统计最短的满足条件的子串
        int startIndex = -1;  // 子串起始位置

        int l = 0, r = -1;  // [l...r]滑动窗口
        int tLength = t.length();
        while (l < filtered_s.length()) {

            if (r + 1 < filtered_s.length() && sCount < tLength) {
                sFreq[filtered_s.charAt(r + 1)]++;
                if (sFreq[filtered_s.charAt(r + 1)] <= tFreq[filtered_s.charAt(r + 1)])  // s[r+1]是t中的未统计的字符
                    sCount++;
                r++;
            } else {
                assert sCount <= tLength;
                if (sCount == tLength && pos.get(r) - pos.get(l) + 1 < minLength) {
                    minLength = pos.get(r) - pos.get(l) + 1;  // 更新最小长度
                    startIndex = pos.get(l);
                }
                sFreq[filtered_s.charAt(l)]--;
                if (sFreq[filtered_s.charAt(l)] < tFreq[filtered_s.charAt(l)])   // s[l]是t中的未统计的字符
                    sCount--;
                l++;
            }
        }

        if (startIndex != -1)
            return s.substring(startIndex, startIndex + minLength);

        return "";
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println((new Solution2()).minWindow("a", "aa"));
//        System.out.println((new Solution2()).minWindow("aa", "aa"));
//        System.out.println((new Solution2()).minWindow("bba", "ab"));
    }
}
