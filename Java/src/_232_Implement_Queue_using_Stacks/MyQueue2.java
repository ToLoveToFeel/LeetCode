package _232_Implement_Queue_using_Stacks;

import java.util.Stack;

/**
 * Date: 2020/8/22 17:14
 * Content:
 */
public class MyQueue2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.empty())
            front = x;
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.empty())
            return stack2.pop();

        while (stack1.size() > 1)
            stack2.push(stack1.pop());
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty())
            return stack2.peek();
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty()  && stack2.empty();
    }
}
