package _0743_Network_Delay_Time;

import java.util.Arrays;

/**
 * Date: 2021/8/2 9:47
 * Content:
 * 执行用时：6 ms, 在所有 Java 提交中击败了86.32%的用户
 * 内存消耗：43 MB, 在所有 Java 提交中击败了10.40%的用户
 */
public class Solution {

    static final int N = 110, INF = 0x3f3f3f3f;

    int[][] g = new int[N][N];
    int[] dist = new int[N];
    boolean[] st = new boolean[N];

    public int networkDelayTime(int[][] times, int n, int k) {

        for (int i = 0; i < N; i++) Arrays.fill(g[i], INF);
        for (int[] e : times) g[e[0]][e[1]] = e[2];
        return dijkstra(k, n);
    }

    private int dijkstra(int start, int n) {

        Arrays.fill(dist, INF);
        Arrays.fill(st, false);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;

            st[t] = true;

            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }

        int res = 0;
        for (int i = 1; i <= n; i++) res = Math.max(res, dist[i]);

        if (res == INF) res = -1;
        return res;
    }

    public static void main(String[] args) {

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println((new Solution()).networkDelayTime(times, 4, 2));  // 2
    }
}
