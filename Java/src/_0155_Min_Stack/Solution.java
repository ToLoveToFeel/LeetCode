package _0155_Min_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/9/24 19:47
 * Content:
 */
public class Solution {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // return -3
        minStack.pop();
        System.out.println(minStack.top());  // return 0
        System.out.println(minStack.getMin());  // return -2
    }
}

class MinStack {

    Deque<Integer> stk;  // 存储对应的元素
    Deque<Integer> f;  // 存储当前stack对应元素中的最小值

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stk = new ArrayDeque<>();
        f = new ArrayDeque<>();
        f.push(Integer.MAX_VALUE);  // 加入这个元素是为了：在第一次向栈中添加元素，方便比较，相当于哨兵
    }

    public void push(int x) {
        stk.push(x);
        f.push(Math.min(f.peek(), x));
    }

    public void pop() {
        stk.pop();
        f.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return f.peek();
    }
}
