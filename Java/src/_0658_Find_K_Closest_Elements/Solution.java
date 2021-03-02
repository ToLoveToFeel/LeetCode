package _0658_Find_K_Closest_Elements;

import java.util.*;

/**
 * Created by WXX on 2021/3/2 9:36
 * 使用堆实现，时间复杂度：O(n*log(k))
 * 执行用时：60 ms, 在所有 Java 提交中击败了5.10%的用户
 * 内存消耗：40.6 MB, 在所有 Java 提交中击败了27.15%的用户
 */
public class Solution {

    static class MyPair implements Comparable<MyPair> {
        int x, y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MyPair o) {
            if (this.x != o.x) return o.x - this.x;
            else return o.y - this.y;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        Queue<MyPair> heap = new PriorityQueue<>();
        for (int v : arr) {
            heap.add(new MyPair(Math.abs(x - v), v));
            if (heap.size() > k) heap.remove();
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) res.add(heap.remove().y);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println((new Solution()).findClosestElements(arr, 4, 3));  // [1, 2, 3, 4]
    }
}
