package _0155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/24 19:47
 * Content:
 */
public class Solution {

    static class MinStack {

        Deque<Integer> stk = new ArrayDeque<>();
        Deque<Integer> f = new ArrayDeque<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            stk.push(val);
            if (f.isEmpty() || val <= f.peek()) f.push(val);
        }

        public void pop() {
            if (stk.peek().equals(f.peek())) f.pop();
            stk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return f.peek();
        }
    }

    public static void main(String[] args) {

//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());  // return -3
//        minStack.pop();
//        System.out.println(minStack.top());  // return 0
//        System.out.println(minStack.getMin());  // return -2
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());  // return -1024
        minStack.pop();
        System.out.println(minStack.getMin());  // return -1024
        minStack.pop();
        System.out.println(minStack.getMin());  // return 512
    }
}
