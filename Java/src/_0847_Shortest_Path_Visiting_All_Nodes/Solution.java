package _0847_Shortest_Path_Visiting_All_Nodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2021/8/6 10:22
 * Content:
 * 执行用时：9 ms, 在所有 Java 提交中击败了78.31%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了39.16%的用户
 */
public class Solution {

    final static int INF = (int) 1e8;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] f = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) Arrays.fill(f[i], INF);

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            f[1 << i][i] = 0;
            q.add(new int[]{1 << i, i});
        }

        while (!q.isEmpty()) {
            int[] t = q.remove();

            for (int z : graph[t[1]]) {
                int s = t[0] | 1 << z;
                if (f[s][z] > f[t[0]][t[1]] + 1) {
                    f[s][z] = f[t[0]][t[1]] + 1;
                    q.add(new int[]{s, z});
                }
            }
        }

        int res = INF;
        for (int i = 0; i < n; i++)
            res = Math.min(res, f[(1 << n) - 1][i]);
        return res;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0},
        };
        System.out.println((new Solution()).shortestPathLength(graph));  // 4
    }
}
