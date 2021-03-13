package _0705_Design_HashSet;

import java.util.Arrays;

/**
 * Created by WXX on 2021/3/13 9:13
 * 执行用时：38 ms, 在所有 Java 提交中击败了15.07%的用户
 * 内存消耗：46.9 MB, 在所有 Java 提交中击败了22.09%的用户
 */
public class Solution {

    static class MyHashSet {

        public static final int N = (int) 1e6 + 10;
        boolean[] res;

        /** Initialize your data structure here. */
        public MyHashSet() {
            res = new boolean[N];
            Arrays.fill(res, false);
        }

        public void add(int key) {
            res[key] = true;
        }

        public void remove(int key) {
            res[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return res[key];
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
