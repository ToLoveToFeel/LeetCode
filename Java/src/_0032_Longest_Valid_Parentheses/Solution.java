package _0032_Longest_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2021/1/5 17:37
 * Content:
 * https://www.bilibili.com/video/BV1PK4y147uk  14:00
 * 思路：如果某段中右括号比左括号多一个，则可以将该段切分开，最长的有效括号不会跨越该段
 * 执行用时：3 ms, 在所有 Java 提交中击败了45.45%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了56.15%的用户
 */
public class Solution {

    public int longestValidParentheses(String s) {

        Deque<Integer> stk = new ArrayDeque<>();

        int res = 0;
        for (int i = 0, start = -1; i < s.length(); i++) {
            if (s.charAt(i) == '(') stk.push(i);
            else {
                if (!stk.isEmpty()) {
                    stk.pop();
                    if (!stk.isEmpty()) res = Math.max(res, i - stk.peek());
                    else res = Math.max(res, i - start);
                } else {
                    start = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).longestValidParentheses("(()"));
        System.out.println((new Solution()).longestValidParentheses("(()()"));
        System.out.println((new Solution()).longestValidParentheses(""));
    }
}
