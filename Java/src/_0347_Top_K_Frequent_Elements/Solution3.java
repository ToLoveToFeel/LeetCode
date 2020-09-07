package _0347_Top_K_Frequent_Elements;

import java.util.*;

class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num) + 1);
            else
                hashMap.put(num, 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashMap.get(a) - hashMap.get(b);
            }
        });
        for (int key : hashMap.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(key);
            else if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.remove());
        }

        // 转换为数组
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 3, 3, 3, 7, 7, 7, 7, 7, 7, 5, 5, 4, 6, 6, 6};
        int[] res = (new Solution3()).topKFrequent(nums, 2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
