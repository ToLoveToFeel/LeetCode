package _1006_Clumsy_Factorial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by WXX on 2021/4/1 9:49
 * 执行用时：13 ms, 在所有 Java 提交中击败了9.03%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了12.26%的用户
 */
public class Solution {

    public int clumsy(int N) {

        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(N);
        for (int i = N - 1, ops = 0; i > 0; i--, ops = (ops + 1) % 4) {
            if (ops == 3) {
                stk.push(-i);
                continue;
            }

            if (ops == 0) stk.push(stk.pop() * i);
            else if (ops == 1) stk.push(stk.pop() / i);
            else stk.push(stk.pop() + i);
        }

        int res = 0;
        while (!stk.isEmpty()) res += stk.pop();

        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).clumsy(4));  // 7
        System.out.println((new Solution()).clumsy(10));  // 12
    }
}
