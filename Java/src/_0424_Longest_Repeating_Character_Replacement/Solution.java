package _0424_Longest_Repeating_Character_Replacement;

/**
 * Date: 2021/2/2 19:33
 * Content:
 * 执行用时：30 ms, 在所有 Java 提交中击败了12.71%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了75.21%的用户
 */
public class Solution {

    public int characterReplacement(String s, int k) {

        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0, j = 0, cnt = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) cnt++;
                if (i - j + 1 - cnt > k) {
                    if (s.charAt(j) == c) cnt--;
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).characterReplacement("ABAB", 2));  // 4
        System.out.println((new Solution()).characterReplacement("AABABBA", 1));  // 4
    }
}
