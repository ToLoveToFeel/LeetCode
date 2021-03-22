package _1514_Path_with_Maximum_Probability;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/10/29 9:30
 * Content: Dijkstra算法：单源最短路径，不能处理负权边
 * 算法步骤：
 * (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值），该题中，找乘法最大值，相当于找加法最小值
 * (2) 确认这个节点的最短路就是当前大小（确定一个解）
 * (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
 * 时间复杂度：O(V^2) 其中V为图中节点个数
 * <p>
 * 执行用时：1172 ms, 在所有 Java 提交中击败了5.07%的用户
 * 内存消耗：49.9 MB, 在所有 Java 提交中击败了63.78%的用户
 */
public class Solution {
    // 存储某条边的信息
    private static class MyPair {
        public int w;  // 顶点
        public double weight;  // 权重

        public MyPair(int v, double weight) {
            this.w = v;
            this.weight = weight;
        }
    }

    // 构建无向无权图：graph[i]存储的为节点 i 连接到的点，以及权重
    private List<List<MyPair>> constructUndirectedWeightGraph(int n, int[][] edges, double[] weights) {
        List<List<MyPair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new MyPair(e[1], weights[i]));
            graph.get(e[1]).add(new MyPair(e[0], weights[i]));
        }

        return graph;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<MyPair>> graph = constructUndirectedWeightGraph(n, edges, succProb);

        double[] dis = new double[n];  // dis[i]存储从源点s到i的最大概率
        dis[start] = 1;  // start到start的概率为1
        boolean[] visited = new boolean[n];  // 存储当前节点是否已经确定了最短路径

        while (true) {
            // (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
            int cur = -1;
            double curProb = 0.0;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dis[v] > curProb) {
                    curProb = dis[v];
                    cur = v;
                }
            }
            if (cur == -1) break;  // 说明所有的点都已经找到了最短路径
            if (cur == end)
                return dis[cur];
            // (2) 确认这个节点的最短路就是当前大小（确定一个解）
            visited[cur] = true;
            // (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
            for (MyPair pair : graph.get(cur)) {
                int w = pair.w;
                if (!visited[w]) {
                    double weight = pair.weight;
                    if (dis[cur] * weight > dis[w])
                        dis[w] = dis[cur] * weight;
                }
            }
        }

        return dis[end];
    }

    public static void main(String[] args) {

//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        double[] succProb = {0.5, 0.5, 0.2};
//        System.out.println((new Solution()).maxProbability(3, edges, succProb, 0, 2));  // 0.25

//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        double[] succProb = {0.5, 0.5, 0.3};
//        System.out.println((new Solution()).maxProbability(3, edges, succProb, 0, 2));  // 0.3

        int[][] edges = {{0, 1}};
        double[] succProb = {0.5};
        System.out.println((new Solution()).maxProbability(3, edges, succProb, 0, 2));  // 0.0
    }
}
