package _0295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

/**
 * Date: 2021/2/6 10:41
 * Content:
 * 执行用时：62 ms, 在所有 Java 提交中击败了85.71%的用户
 * 内存消耗：49.8 MB, 在所有 Java 提交中击败了35.79%的用户
 */
public class MedianFinder {

    PriorityQueue<Integer> up = new PriorityQueue<>();  // 小顶堆
    PriorityQueue<Integer> down = new PriorityQueue<>((o1, o2) -> o2 - o1);  // 大顶堆

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (down.isEmpty() || num <= down.peek()) {
            down.add(num);
            if (down.size() > up.size() + 1) {
                up.add(down.peek());
                down.remove();
            }
        } else {
            up.add(num);
            if (up.size() > down.size()) {
                down.add(up.peek());
                up.remove();
            }
        }
    }

    public double findMedian() {
        if ((up.size() + down.size()) % 2 == 1) return down.peek();
        else return (up.peek() + down.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianFinder t = new MedianFinder();
        t.addNum(1);
        t.addNum(2);
        System.out.println(t.findMedian());  // 1.5
        t.addNum(3);
        System.out.println(t.findMedian());  // 2
    }
}
