package _0215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;  // 默认最小堆
import java.util.Queue;

/**
 * 时间复杂度：O(nlogk)
 * 空间复杂度：O(k)
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            if (pq.size() != k)
                pq.add(e);
            else if (e > pq.peek()) {
                pq.poll();
                pq.add(e);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println((new Solution3()).findKthLargest(nums, k));
    }
}
