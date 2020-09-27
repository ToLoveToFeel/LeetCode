package _0150_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/27 19:26
 * Content:
 * 栈
 */
public class Solution {
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int num1, int num2, String operator) {
        int res = 0;
        if (operator.equals("+"))
            res = num2 + num1;
        else if (operator.equals("-"))
            res = num2 - num1;
        else if (operator.equals("*"))
            res = num2 * num1;
        else
            res = num2 / num1;
        return res;
    }

    public int evalRPN(String[] tokens) {
        int index = 0;  // 记录考察到的 token 中数据的索引
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(Integer.valueOf(tokens[index++]));
        while (index < tokens.length) {
            if (isOperator(tokens[index])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculate(num1, num2, tokens[index]));
            } else {
                stack.push(Integer.valueOf(tokens[index]));
            }
            index++;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};  // 9
//        String[] tokens = {"4", "13", "5", "/", "+"};  // 6
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};  // 22
        System.out.println((new Solution()).evalRPN(tokens));
    }
}
