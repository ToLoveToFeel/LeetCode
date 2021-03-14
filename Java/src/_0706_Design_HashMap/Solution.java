package _0706_Design_HashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXX on 2021/3/14 10:41
 * 拉链法
 * 执行用时：26 ms, 在所有 Java 提交中击败了61.90%的用户
 * 内存消耗：44.9 MB, 在所有 Java 提交中击败了30.46%的用户
 */
public class Solution {

    static class MyHashMap {

        public static final int N = 19997;

        static class Node {
            int key, value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        List<Node>[] h = new List[N];


        public MyHashMap() {
            for (int i = 0; i < N; i++)
                h[i] = new ArrayList<>();
        }

        private int find(List<Node> h, int key) {
            for (int i = 0; i < h.size(); i++)
                if (h.get(i).key == key)
                    return i;
            return -1;
        }

        public void put(int key, int value) {
            int t = key % N;
            int k = find(h[t], key);
            if (k == -1) h[t].add(new Node(key, value));
            else h[t].get(k).value = value;
        }

        public int get(int key) {
            int t = key % N;
            int k = find(h[t], key);
            if (k == -1) return -1;
            return h[t].get(k).value;
        }

        public void remove(int key) {
            int t = key % N;
            int k = find(h[t], key);
            if (k != -1) h[t].remove(k);
        }
    }

    public static void main(String[] args) {

        MyHashMap t = new MyHashMap();
        t.put(1, 1);
        t.put(2, 2);
        System.out.println(t.get(1));  // 1
        System.out.println(t.get(3));  // -1
        t.put(2, 12);
        System.out.println(t.get(2));  // 12
        t.remove(2);
        System.out.println(t.get(2));  // -1
    }
}
