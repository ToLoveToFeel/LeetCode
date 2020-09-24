package _0622_Design_Circular_Queue;

/**
 * Date: 2020/9/24 14:33
 * Content:
 */
public class Solution {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
        System.out.println(circularQueue.Front());  // 返回 2
    }
}

class MyCircularQueue {
    private final int[] data;
    private int front, tail;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        tail = -1;  // 指向最后一个元素
        size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size == data.length)
            return false;

        tail = (tail + 1) % data.length;
        data[tail] = value;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0)
            return false;
        front = (front + 1) % data.length;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size == 0)
            return -1;
        return data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (size == 0)
            return -1;
        return data[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == data.length;
    }
}
