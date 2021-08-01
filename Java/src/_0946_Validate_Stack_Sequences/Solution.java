package _0946_Validate_Stack_Sequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2021/8/1 11:16
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了92.64%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了14.38%的用户
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stk.push(pushed[i]);
            while (!stk.isEmpty() && stk.peek() == popped[j]) {
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {

        int[]  pushed = {1, 2, 3, 4, 5}, poped = {4, 5, 3, 2, 1};
        System.out.println((new Solution()).validateStackSequences(pushed, poped));  // true
    }
}
