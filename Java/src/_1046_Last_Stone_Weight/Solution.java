package _1046_Last_Stone_Weight;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Date: 2020/12/30 9:31
 * Content:
 * 执行用时：2 ms, 在所有 Java 提交中击败了41.83%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了29.15%的用户
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int x : stones) heap.add(x);
        while (heap.size() > 1) {
            int y = heap.remove(), x = heap.remove();
            if (x == y) continue;
            heap.add(y - x);
        }

        return heap.size() == 1 ? heap.remove() : 0;
    }

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println((new Solution()).lastStoneWeight(stones));
    }
}
