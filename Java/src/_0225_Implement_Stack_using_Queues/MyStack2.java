package _0225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2020/8/22 15:37
 * Content:
 */
class MyStack2 {
    Queue<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        MyStack2 obj = new MyStack2();
        obj.push(1);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
