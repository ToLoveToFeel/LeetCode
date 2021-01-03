package _0347_Top_K_Frequent_Elements;

import _0000_study._common.Output;

import java.util.*;

/**
 * 执行用时：17 ms, 在所有 Java 提交中击败了41.86%的用户
 * 内存消耗：40.9 MB, 在所有 Java 提交中击败了83.93%的用户
 */
class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 统计词频
        for (int num : nums)
            if (hashMap.containsKey(num)) hashMap.put(num, hashMap.get(num) + 1);
            else hashMap.put(num, 1);

        // 使用优先队列解决
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> hashMap.get(a) - hashMap.get(b)
        );  // 最小堆
        for (int key : hashMap.keySet()) {
            if (priorityQueue.size() < k) priorityQueue.add(key);
            else if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty()) ret.add(priorityQueue.remove());
        // 转换为数组
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) res[i] = ret.get(i);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 3, 3, 3, 7, 7, 7, 7, 7, 7, 5, 5, 4, 6, 6, 6};
        int[] res = (new Solution()).topKFrequent(nums, 2);
        Output.OutputBasicArray1D(res);
    }
}
