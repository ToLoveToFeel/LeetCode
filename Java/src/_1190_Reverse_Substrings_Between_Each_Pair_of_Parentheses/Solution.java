package _1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2021/5/26 10:16
 * 执行用时：2 ms, 在所有 Java 提交中击败了70.99%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了85.15%的用户
 */
public class Solution {

    public String reverseParentheses(String s) {
        Deque<StringBuilder> stk = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(res);
                res = new StringBuilder();
            } else if (c == ')') {
                res.reverse();
                res = stk.pop().append(res);
            } else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).reverseParentheses("(u(love)i)"));
        System.out.println((new Solution()).reverseParentheses("(a(bc(def)g)h)"));
        System.out.println((new Solution()).reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
