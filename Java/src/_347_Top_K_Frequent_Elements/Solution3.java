package _347_Top_K_Frequent_Elements;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue; //默认最小堆
import java.util.Comparator;

class Solution3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num:nums) {
            if (hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num)+1);
            else
                hashMap.put(num, 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashMap.get(a) - hashMap.get(b);
            }
        });
        for (int key:hashMap.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(key);
            else if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        LinkedList<Integer> ret = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.remove());
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,1,3,3,3,7,7,7,7,7,7,5,5,4,6,6,6};
        System.out.println((new Solution3()).topKFrequent(nums, 2));
    }
}
