package _0705_Design_HashSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WXX on 2021/3/14 20:50
 * 执行用时：25 ms, 在所有 Java 提交中击败了30.85%的用户
 * 内存消耗：46.6 MB, 在所有 Java 提交中击败了35.39%的用户
 */
public class Solution2 {

    static class MyHashSet {

        public static final int N = 20003;
        List<Integer>[] h = new List[N];

        public MyHashSet() {
            for (int i = 0; i < N; i++)
                h[i] = new ArrayList<>();
        }

        private int find(List<Integer> h, int x) {
            for (int i = 0; i < h.size(); i++)
                if (h.get(i).equals(x))
                    return i;
            return -1;
        }

        public void add(int key) {
            int t = key % N;
            int k = find(h[t], key);
            if (k == -1) h[t].add(key);
            else h[t].set(k, key);
        }

        public void remove(int key) {
            int t = key % N;
            int k = find(h[t], key);
            if (k != -1) h[t].remove(k);
        }

        public boolean contains(int key) {
            int t = key % N;
            int k = find(h[t], key);
            return k != -1;
        }
    }

    public static void main(String[] args) {

        MyHashSet t = new MyHashSet();
        t.add(1);
        t.add(2);
        System.out.println(t.contains(1));  // true
        System.out.println(t.contains(3));  // false
        t.remove(2);
        System.out.println(t.contains(2));  // false
    }
}
