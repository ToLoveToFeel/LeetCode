package _0232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by WXX on 2021/3/5 9:58
 */
public class Solution {

    static class MyQueue {
        private Deque<Integer> stk1;
        private Deque<Integer> stk2;

        public MyQueue() {
            stk1 = new ArrayDeque<>();
            stk2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stk1.push(x);
        }

        public int pop() {
            while (stk1.size() > 0) stk2.push(stk1.pop());
            int res = stk2.pop();
            while (stk2.size() > 0) stk1.push(stk2.pop());
            return res;
        }

        public int peek() {
            while (stk1.size() > 0) stk2.push(stk1.pop());
            int res = stk2.peek();
            while (stk2.size() > 0) stk1.push(stk2.pop());
            return res;
        }

        public boolean empty() {
            return stk1.isEmpty();
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
