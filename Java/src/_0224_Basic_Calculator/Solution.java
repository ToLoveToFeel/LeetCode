package _0224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by WXX on 2021/3/10 10:45
 * 执行用时：16 ms, 在所有 Java 提交中击败了40.01%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了51.96%的用户
 */
public class Solution {

    Deque<Integer> num = new ArrayDeque<>();  // 存储数字
    Deque<Character> ops = new ArrayDeque<>();  // 存储运算符和括号

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void eval() {
        int b = num.pop(), a = num.pop();
        char c = ops.pop();
        int r;
        if (c == '+') r = a + b;
        else r = a - b;
        num.push(r);
    }

    public int calculate(String s) {

        if (s.charAt(0) == '-') s = '0' + s;
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (c == ' ') continue;
            if (isDigit(c)) {
                int j = i, t = 0;
                while (j < a.length && isDigit(a[j])) t = t * 10 + (a[j++] - '0');
                i = j - 1;
                num.push(t);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') eval();
                ops.pop();
            } else {
                while (!ops.isEmpty() && ops.peek() != '(') eval();
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval();
        return num.peek();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).calculate("1 + 1"));  // 2
        System.out.println((new Solution()).calculate(" 2-1 + 2 "));  // 3
        System.out.println((new Solution()).calculate("(1+(4+5+2)-3)+(6+8) "));  // 23
        System.out.println((new Solution()).calculate("-2+ 1"));  // -1
    }
}
