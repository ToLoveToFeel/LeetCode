package _0739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/25 14:40
 * Content:
 * 单调栈：单调递减的栈，一般单调栈存储的都是下标
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = (new Solution()).dailyTemperatures(T);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
