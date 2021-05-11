package _0347_Top_K_Frequent_Elements;

import _0000_study._common.Output;

import java.util.*;

/**
 * 执行用时：17 ms, 在所有 Java 提交中击败了41.86%的用户
 * 内存消耗：40.9 MB, 在所有 Java 提交中击败了83.93%的用户
 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // (1) 使用哈希表统计各个元素出现的次数；
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int x : nums) hash.put(x, hash.getOrDefault(x, 0) + 1);
        // (2) 使用小顶堆获得出现频率前k高的元素。
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> hash.get(a) - hash.get(b));
        for (int key : hash.keySet()) {
            if (heap.size() < k) heap.add(key);
            else if (hash.get(key) > hash.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }

        int[] res = new int[heap.size()];
        for (int i = 0; i < res.length; i++) res[i] = heap.remove();
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        Output.OutputBasicArray1D((new Solution()).topKFrequent(nums, 2));  // [1, 2]
    }
}
