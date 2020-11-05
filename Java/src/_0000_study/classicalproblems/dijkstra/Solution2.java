package _0000_study.classicalproblems.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Date: 2020/10/29 9:30
 * Content:
 * Dijkstra算法：单源最短路径，不能处理负权边
 * 算法步骤：
 * (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值），该题中，找乘法最大值，相当于找加法最小值
 * (2) 确认这个节点的最短路就是当前大小（确定一个解）
 * (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
 * 时间复杂度：O(E*logE) 其中E为图中边的条数
 * <p>
 * 执行用时：40 ms, 在所有 Java 提交中击败了75.28%的用户
 * 内存消耗：52.6 MB, 在所有 Java 提交中击败了17.96%的用户
 */
public class Solution2 {
    // 存储某条边的信息
    private static class MyPair {
        public int w;  // 顶点
        public double weight;  // 权重

        public MyPair(int w, double weight) {
            this.w = w;
            this.weight = weight;
        }
    }

    // 将源点s到 v 的的最短路径dis封装进 Node 中，为了方便在优先队列中根据 dis 的值找到对应的节点
    private static class Node implements Comparable<Node> {
        public int v;
        public double dis;

        public Node(int v, double dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {  // PriorityQueue默认是最小堆，为了升序排列，需要取反
            return -Double.compare(dis, another.dis);
        }
    }

    // 构建无向有权图：graph[i]存储的为节点 i 连接到的点，以及权重
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

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 1));
        while (!pq.isEmpty()) {
            // (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
            int cur = pq.remove().v;

            if (cur == end)
                return dis[cur];
            if (visited[cur]) continue;  // 因为第(3)步更新了dis，所以cur可能在优先队列中存在多份，可以放在上一个if之前
            // (2) 确认这个节点的最短路就是当前大小（确定一个解）
            visited[cur] = true;
            // (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
            for (MyPair pair : graph.get(cur)) {
                int w = pair.w;
                if (!visited[w]) {
                    double weight = pair.weight;
                    if (dis[cur] * weight > dis[w]) {
                        dis[w] = dis[cur] * weight;
                        pq.add(new Node(w, dis[w]));  // 这句话的副作用：可能使得以w为最短路径的Node顶点有多份
                    }
                }
            }
        }

        return dis[end];
    }

    public static void main(String[] args) {
        int n = 3;  // 0.25
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        System.out.println((new Solution2()).maxProbability(n, edges, succProb, start, end));
//        int n = 3;  // 0.3
//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
//        double[] succProb = {0.5, 0.5, 0.3};
//        int start = 0;
//        int end = 2;
//        System.out.println((new Solution()).maxProbability(n, edges, succProb, start, end));
//        int n = 3;  // 0.0
//        int[][] edges = {{0, 1}};
//        double[] succProb = {0.5};
//        int start = 0;
//        int end = 2;
//        System.out.println((new Solution()).maxProbability(n, edges, succProb, start, end));
    }
}
