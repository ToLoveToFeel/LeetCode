package _1928_Minimum_Cost_to_Reach_Destination_in_Time;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021/7/12 14:46
 * Content:
 * 执行用时：639 ms, 在所有 Java 提交中击败了39.47%的用户
 * 内存消耗：61.7 MB, 在所有 Java 提交中击败了5.26%的用户
 */
public class Solution {

    static final int N = 1010, M = 2010, INF = 0x3f3f3f3f;

    int[] h = new int[N], e = new int[M], w = new int[M], ne = new int[M];
    int idx = 0;
    int[][] dist = new int[N][N];
    boolean[][] st = new boolean[N][N];

    private void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int minCost(int m, int[][] edges, int[] pf) {
        int n = pf.length;

        Arrays.fill(h, -1);
        idx = 0;
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            add(a, b, c);
            add(b, a, c);
        }

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
        dist[0][0] = pf[0];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});  // (顶点, 用时)

        while (!q.isEmpty()) {
            int[] t = q.remove();
            st[t[0]][t[1]] = false;

            for (int i = h[t[0]]; i != -1; i = ne[i]) {
                int x = e[i];  // 点
                int y = t[1] + w[i];
                if (y > m) continue;  // 时间超过m，没必要更新
                if (dist[x][y] > dist[t[0]][t[1]] + pf[x]) {
                    dist[x][y] = dist[t[0]][t[1]] + pf[x];
                    if (!st[x][y]) {
                        q.add(new int[]{x, y});
                        st[x][y] = true;
                    }
                }
            }
        }

        int res = INF;
        for (int i = 0; i <= m; i++) res = Math.min(res, dist[n - 1][i]);
        if (res == INF) res = -1;
        return res;
    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        System.out.println((new Solution()).minCost(30, edges, passingFees));  // 11
    }
}
