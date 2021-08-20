package _0541_Reverse_String_II;

/**
 * Date: 2021/8/20 9:58
 * 执行用时：1 ms, 在所有 Java 提交中击败了93.16%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了22.48%的用户
 */
public class Solution {

    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2 * k) {
            res.append(new StringBuilder(s.substring(i, Math.min(i + k, s.length()))).reverse());
            if (i + k < s.length()) res.append(s, i + k, Math.min(i + 2 * k, s.length()));
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).reverseStr("abcd", 2));  // bacd
        System.out.println((new Solution()).reverseStr("abcd", 3));  // cbad
        System.out.println((new Solution()).reverseStr("abcd", 4));  // dcba
        System.out.println((new Solution()).reverseStr("abcd", 5));  // dcba
    }
}
