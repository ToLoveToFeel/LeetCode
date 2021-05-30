package _0395_Longest_Substring_with_At_Least_K_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2021/2/20 10:51
 * Content:
 * 执行用时：25 ms, 在所有 Java 提交中击败了16.07%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了14.98%的用户
 */
public class Solution {

    int K;
    Map<Character, Integer> cnt = new HashMap<>();  // 不同字符在区间中出现的次数
    int x = 0, y = 0;  // x表示s[j...i]中不同字符的数量，y表示s[j...i]中满足字符数量大于K的字符的数量

    private void add(char c) {
        if (cnt.getOrDefault(c, 0) == 0) x++;
        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        if (cnt.get(c) == K) y++;
    }

    private void del(char c) {
        if (cnt.getOrDefault(c, 0) == K) y--;
        cnt.put(c, cnt.getOrDefault(c, 0) - 1);
        if (cnt.get(c) == 0) x--;
    }

    public int longestSubstring(String s, int _K) {

        K = _K;
        int res = 0;
        for (int k = 1; k <= 26; k++) {
            cnt.clear();
            x = y = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                add(s.charAt(i));
                while (x > k) del(s.charAt(j++));
                if (x == y) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).longestSubstring("aaabb", 3));  // 3
        System.out.println((new Solution()).longestSubstring("ababbc", 2));  // 5
        System.out.println((new Solution()).longestSubstring("baaabcb", 3));  // 3
    }
}
