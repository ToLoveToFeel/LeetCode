package _0844_Backspace_String_Compare;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/10/19 9:08
 * Content:
 * 栈
 */
public class Solution {
    // 得到不含退格的字符串
    private String result(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#')
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

//        return sb.toString();
        return sb.reverse().toString();
    }

    public boolean backspaceCompare(String S, String T) {
        return result(S).equals(result(T));
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).backspaceCompare("ab#c", "ad#c"));  // true
        System.out.println((new Solution()).backspaceCompare("ab##", "c#d#"));  // true
        System.out.println((new Solution()).backspaceCompare("a##c", "#a#c"));  // true
        System.out.println((new Solution()).backspaceCompare("a#c", "b"));  // false
    }
}
