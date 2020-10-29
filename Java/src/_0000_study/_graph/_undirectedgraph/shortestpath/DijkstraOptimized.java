package _0000_study._graph._undirectedgraph.shortestpath;

import _0000_study._graph.graphrepresentation.WeightedGraph;
import _0000_study._graph.util.FilePrefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

/*
 * Dijkstra算法：单源最短路径，不能处理负权边
 * 算法步骤：
 * (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
 * (2) 确认这个节点的最短路就是当前大小（确定一个解）
 * (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
 * 时间复杂度：O(E*logE) 其中E为图中边的条数
 */

public class DijkstraOptimized {

    private WeightedGraph G;
    private int s;  // 源点
    private int[] dis;  // dis[i]存储从源点s到i的最短路径
    private boolean[] visited;  // 存储当前节点是否已经确定了最短路径
    private int[] pre;  // pre[w]=v 代表到 w 的最短路径需要经过的上一个节点为 v

    // 将源点s到 v 的的最短路径dis封装进 Node 中，为了方便在优先队列中根据 dis 的值找到对应的节点
    private class Node implements Comparable<Node> {

        public int v, dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {
            return dis - another.dis;
        }
    }

    public DijkstraOptimized(WeightedGraph G, int s) {

        this.G = G;

        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);  // 初始化 源点s 到 任意点的距离都是无穷大
        dis[s] = 0;  // 源点s到源点s的最短路径为0

        pre = new int[G.V()];
        Arrays.fill(pre, -1);
        pre[s] = s;

        visited = new boolean[G.V()];

        PriorityQueue<Node> pq = new PriorityQueue<>();  // 默认是最小堆
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            // (1) 找到当前还没有得到结果的节点中最短路径对应的节点（找最小值）
            int cur = pq.remove().v;

            if (visited[cur]) continue;  // 因为第(3)步更新了dis，所以cur可能在优先队列中存在多份
            // (2) 确认这个节点的最短路就是当前大小（确定一个解）
            visited[cur] = true;
            // (3) 根据这个节点的最短路大小，更新其他节点的路径长度（更新）
            for (int w : G.adj(cur))
                if (!visited[w]) {
                    if (dis[cur] + G.getWeight(cur, w) < dis[w]) {
                        dis[w] = dis[cur] + G.getWeight(cur, w);
                        pq.add(new Node(w, dis[w]));  // 这句话的副作用：可能使得以w为最短路径的Node顶点有多份
                        pre[w] = cur;
                    }
                }
        }
    }

    public boolean isConnectedTo(int v) {

        G.validateVertex(v);
        return visited[v];
    }

    public int distTo(int v) {

        G.validateVertex(v);
        return dis[v];
    }

    public Iterable<Integer> path(int t) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (!isConnectedTo(t)) return res;

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }

    static public void main(String[] args) {
        String graphPath = FilePrefix.pathPrefix + "_undirectedgraph/shortestpath";
        WeightedGraph g = new WeightedGraph(graphPath + "/g.txt");

        DijkstraOptimized dij = new DijkstraOptimized(g, 0);
        for (int v = 0; v < g.V(); v++)
            System.out.print(dij.distTo(v) + " ");
        System.out.println();

        System.out.println(dij.path(3));
    }
}
