package _0407_Trapping_Rain_Water_II;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date: 2021/4/24 17:46
 */
public class Solution {

    static final int N = 1200;  // lc上虽然说行数列数不会超过110，但是提交时存在(200,200)的矩阵

    int[][] dist = new int[N][N];  // dist[i][j]表示到达(i, j)的所有路径中边权最大值的最小值
    boolean[][] st = new boolean[N][N];  // 堆优化版的dijkstra算法中判重数组, 为true代表该点已经求出答案

    static class Node implements Comparable<Node> {
        int x, y, d;  // d: 到达(x, y)的所有路径中边权最大值的最小值

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return d - o.d;  // 默认小顶堆，需要使用小顶堆
        }
    }

    public int trapRainWater(int[][] h) {

        int n = h.length, m = h[0].length;

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        int res = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>();

        // 将四周的点加入优先队列
        for (int i = 0; i < n; i++) {
            heap.add(new Node(i, 0, h[i][0]));
            dist[i][0] = h[i][0];
            heap.add(new Node(i, m - 1, h[i][m - 1]));
            dist[i][m - 1] = h[i][m - 1];
        }
        for (int i = 1; i < m - 1; i++) {
            heap.add(new Node(0, i, h[0][i]));
            dist[0][i] = h[0][i];
            heap.add(new Node(n - 1, i, h[n - 1][i]));
            dist[n - 1][i] = h[n - 1][i];
        }

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

        while (!heap.isEmpty()) {
            Node t = heap.remove();

            if (st[t.x][t.y]) continue;
            st[t.x][t.y] = true;

            res += t.d - h[t.x][t.y];

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (dist[x][y] > Math.max(t.d, h[x][y])) {  // (t.x, t.y)到(x, y)的边权为h[x][y]
                    dist[x][y] = Math.max(t.d, h[x][y]);
                    heap.add(new Node(x, y, dist[x][y]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] h = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        System.out.println((new Solution()).trapRainWater(h));  // 4
    }
}
