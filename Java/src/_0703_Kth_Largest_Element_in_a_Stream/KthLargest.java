package _0703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Date: 2021/2/11 19:32
 * Content:
 * 执行用时：22 ms, 在所有 Java 提交中击败了30.71%的用户
 * 内存消耗：44 MB, 在所有 Java 提交中击败了12.56%的用户
 */
public class KthLargest {

    Queue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int _k, int[] nums) {
        k = _k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.remove();
        return pq.peek();
    }

    public static void main(String[] args) {

        KthLargest t = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(t.add(3));  // 4
        System.out.println(t.add(5));  // 5
        System.out.println(t.add(10));  // 5
        System.out.println(t.add(9));  // 8
        System.out.println(t.add(4));  // 8
    }
}
