package _1544_Make_The_String_Great;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/10/3 10:11
 * Content:
 * 栈
 */
public class Solution {
    private boolean isUpperCase(Character c) {
        return c >= 'A' && c <= 'Z';
    }

    private Character toLowerCase(Character c) {
        return (char) (c + 'a' - 'A');
    }

    private boolean isLowerCase(Character c) {
        return c >= 'a' && c <= 'z';
    }

    private Character toUpperCase(Character c) {
        return (char) (c + 'A' - 'a');
    }

    public String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 栈非空, 并且 ((c 是大写, 并且栈顶是其对应小写) 或者 (c 是小写, 并且栈顶是其对应大写))
            if (!stack.isEmpty() &&
                    ((isUpperCase(c) && stack.peek() == toLowerCase(c)) ||
                            (isLowerCase(c) && stack.peek() == toUpperCase(c))))
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String s = "leEeetcode";
//        String s = "abBAcC";
//        String s = "s";
        String s = "Pp";
        System.out.println((new Solution()).makeGood(s));
    }
}
