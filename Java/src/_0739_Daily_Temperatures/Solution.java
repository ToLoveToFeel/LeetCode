package _0739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Date: 2020/9/25 14:40
 * Content:
 * 单调栈：单调递减的栈，一般单调栈存储的都是下标
 */
public class Solution {

    public int[] dailyTemperatures(int[] t) {

        int[] res = new int[t.length];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < t.length; i++) {
            while (!stk.isEmpty() && t[i] > t[stk.peek()]) {
                res[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString((new Solution()).dailyTemperatures(t)));
    }
}
