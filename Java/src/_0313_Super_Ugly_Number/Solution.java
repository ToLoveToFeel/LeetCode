package _0313_Super_Ugly_Number;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Date: 2021/2/13 9:37
 * Content: 多路归并
 * 执行用时：48 ms, 在所有 Java 提交中击败了31.71%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了31.14%的用户
 */
public class Solution {

    // (指针对应的数 * 该指针指向的质数，指针下标)
    //  比如：初始，指针都指向0，q[0] = 1, (q[0]*x, 0)
    static class MyPair implements Comparable<MyPair> {
        int x, y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MyPair o) {
            return this.x - o.x;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {

        Queue<MyPair> pq = new PriorityQueue<>();  // 默认小顶堆
        // 刚开始primes.size()个指针下标都指向0
        for (int x : primes) pq.add(new MyPair(x, 0));

        int[] q = new int[n];
        q[0] = 1;
        for (int i = 1; i < n; ) {
            MyPair t = pq.remove();
            if (t.x != q[i - 1]) q[i++] = t.x;
            int idx = t.y, p = t.x / q[idx];
            pq.add(new MyPair(p * q[idx + 1], idx + 1));
        }
        return q[n - 1];
    }

    public static void main(String[] args) {

        int n = 12;
        int[] primes = {2, 7, 13, 19};
        System.out.println((new Solution()).nthSuperUglyNumber(n, primes));  // 32
    }
}
