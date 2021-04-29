package _0403_Frog_Jump;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021/4/29 10:33
 */
public class Solution {

    static class MyPair {
        int p, k;  // (当前在stones中的下标为p的位置，且上一步跳跃了k步)

        public MyPair(int p, int k) {
            this.p = p;
            this.k = k;
        }
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) hash.put(stones[i], i);

        boolean[][] st = new boolean[n][n];
        Queue<MyPair> q = new LinkedList<>();
        q.add(new MyPair(0, 0));
        st[0][0] = true;
        while (!q.isEmpty()) {
            MyPair t = q.remove();
            int p = t.p, k = t.k;

            if (p == n - 1) return true;

            for (int i = -1; i <= 1; i++) {
                int nk = k + i;
                if (nk <= 0 || !hash.containsKey(stones[p] + nk)) continue;

                int np = hash.get(stones[p] + nk);
                if (st[np][nk]) continue;

                q.add(new MyPair(np, nk));
                st[np][nk] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));  // true
    }
}
