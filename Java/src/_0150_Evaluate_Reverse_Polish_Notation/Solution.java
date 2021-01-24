package _0150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/27 19:26
 * Content: 栈
 * 执行用时：6 ms, 在所有 Java 提交中击败了88.34%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了48.23%的用户
 */
public class Solution {

    private boolean isOperator(String s) {

        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int x, int y, String operator) {
        int res = 0;

        if (operator.equals("+")) res = y + x;
        else if (operator.equals("-")) res = y - x;
        else if (operator.equals("*")) res = y * x;
        else res = y / x;

        return res;
    }

    public int evalRPN(String[] tokens) {

        int i = 0;  // 记录考察到的 token 中数据的索引
        Deque<Integer> stk = new ArrayDeque<>();

        stk.push(Integer.valueOf(tokens[i++]));
        while (i < tokens.length) {
            if (isOperator(tokens[i])) {
                int x = stk.pop(), y = stk.pop();
                stk.push(calculate(x, y, tokens[i]));
            } else stk.push(Integer.valueOf(tokens[i]));
            i++;
        }

        return stk.pop();
    }

    public static void main(String[] args) {

//        String[] tokens = {"2", "1", "+", "3", "*"};  // 9
//        String[] tokens = {"4", "13", "5", "/", "+"};  // 6
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};  // 22
        System.out.println((new Solution()).evalRPN(tokens));
    }
}
