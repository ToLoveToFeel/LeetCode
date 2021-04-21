package _0402_Remove_K_Digits;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/11/15 11:27
 * Content: 栈
 * 执行用时：10 ms, 在所有 Java 提交中击败了57.78%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了21.50%的用户
 */
public class Solution {

    public String removeKdigits(String num, int k) {

        Deque<Character> stk = new ArrayDeque<>();
        stk.push('0');
        for (char c : num.toCharArray()) {
            while (k > 0 && c < stk.peek()) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        while (k-- > 0)  stk.pop();

        // 栈转为String
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) sb.append(stk.pop());
        String res = sb.reverse().toString();
        // 去掉前导0
        k = 0;
        while (k + 1 < res.length() && res.charAt(k) == '0') k++;
        return res.substring(k);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).removeKdigits("1432219", 3));
        System.out.println((new Solution()).removeKdigits("100200", 1));
        System.out.println((new Solution()).removeKdigits("10", 1));
    }
}
