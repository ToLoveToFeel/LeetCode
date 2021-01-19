package _1584_Min_Cost_to_Connect_All_Points;

import java.util.Arrays;

/**
 * Date: 2021/1/19 4:00 下午
 * Content:
 * 执行用时：39 ms, 在所有 Java 提交中击败了88.42%的用户
 * 内存消耗：42.6 MB, 在所有 Java 提交中击败了86.28%的用户
 */
public class Solution {

    public static final int N = 1010;
    public static final int INF = 0x3f3f3f3f;

    static int n;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public int minCostConnectPoints(int[][] points) {

        n = points.length;

        // 建图
        for (int i = 0; i < n; i++) g[i][i] = INF;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i], p2 = points[j];
                g[i][j] = g[j][i] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
            }
        }

        // prim算法
        Arrays.fill(dist, INF);
        Arrays.fill(st, false);  // 不加上这句话Leetcode无法通过
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            if (i != 0) res += dist[t];
            st[t] = true;
            for (int j = 0; j < n; j++) dist[j] = Math.min(dist[j], g[t][j]);
        }

        return res;
    }

    public static void main(String[] args) {

//        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {7, 0}};  // 20
        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};  // 18
        System.out.println((new Solution()).minCostConnectPoints(points));
    }
}
