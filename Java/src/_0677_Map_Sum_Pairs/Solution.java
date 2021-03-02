package _0677_Map_Sum_Pairs;

import java.util.Arrays;

/**
 * Created by WXX on 2021/3/2 19:06
 * 执行用时：19 ms, 在所有 Java 提交中击败了13.03%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了5.02%的用户
 */
public class Solution {

    static class MapSum {

        public static final int N = 2510;

        int[][] son = new int[N][26];
        int[] V = new int[N], S = new int[N];  // V存储当前节点的权值，S存储以该节点对应前缀的子树的权值和
        int idx;

        void add(String s, int value, int last) {
            int p = 0;
            for (char c : s.toCharArray()) {
                int u = c - 'a';
                if (son[p][u] == 0) son[p][u] = ++idx;
                p = son[p][u];
                S[p] += value - last;
            }
            V[p] = value;
        }

        int query(String s) {
            int p = 0;
            for (char c : s.toCharArray()) {
                int u = c - 'a';
                if (son[p][u] == 0) return 0;
                p = son[p][u];
            }
            return p;
        }

        /** Initialize your data structure here. */
        public MapSum() {
            for (int i = 0; i < N; i++) Arrays.fill(son[i], 0);
            idx = 0;
            Arrays.fill(V, 0);
            Arrays.fill(S, 0);
        }

        public void insert(String key, int val) {
            add(key, val, V[query(key)]);
        }

        public int sum(String prefix) {
            return S[query(prefix)];
        }
    }

    public static void main(String[] args) {

        MapSum t = new MapSum();
        t.insert("apple", 3);
        System.out.println(t.sum("ap"));  // return 3 (apple = 3)
        t.insert("app", 2);
        System.out.println(t.sum("ap"));  // return 5 (apple + app = 3 + 2 = 5)
    }
}
