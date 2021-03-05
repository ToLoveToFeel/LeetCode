package _0232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by WXX on 2021/3/5 9:58
 * stk2用于缓存元素，一旦stk2为空，就将元素移到stk2中
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了71.16%的用户
 */
public class Solution2 {

    static class MyQueue {

        private Deque<Integer> stk1;
        private Deque<Integer> stk2;
        int front;

        public MyQueue() {
            stk1 = new ArrayDeque<>();
            stk2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stk1.isEmpty()) front = x;
            stk1.push(x);
        }

        public int pop() {
            if (!stk2.isEmpty()) return stk2.pop();

            while (stk1.size() > 1) stk2.push(stk1.pop());
            return stk1.pop();
        }

        public int peek() {
            if (!stk2.isEmpty()) return stk2.peek();
            return front;
        }

        public boolean empty() {
            return stk1.isEmpty() && stk2.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyQueue t = new MyQueue();
        t.push(1);
        t.push(2);
        System.out.println(t.peek());  // 1
        System.out.println(t.pop());  // 1
        System.out.println(t.empty());  // false
    }
}
