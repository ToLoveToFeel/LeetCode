package _0347_Top_K_Frequent_Elements;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue; //默认最小堆

class Solution {
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num:nums) {
            if (hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num)+1);
            else
                hashMap.put(num, 1);
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key:hashMap.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            else if (hashMap.get(key) > priorityQueue.peek().freq) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            }
        }

        LinkedList<Integer> ret = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.remove().e);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,1,3,3,3,7,7,7,7,7,7,5,5,4,6,6,6};
        System.out.println((new Solution()).topKFrequent(nums, 1));
    }
}
