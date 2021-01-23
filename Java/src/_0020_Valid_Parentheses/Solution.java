package _0020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了74.09%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了28.18%的用户
 */
public class Solution {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isValid("[()]{}"));  // true
        System.out.println((new Solution()).isValid("[()]}"));  // false
    }
}
