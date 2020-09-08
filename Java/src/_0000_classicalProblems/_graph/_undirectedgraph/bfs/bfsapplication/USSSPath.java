package _0000_classicalProblems._graph._undirectedgraph.bfs.bfsapplication;

import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class USSSPath {
    // Unweighted Single Source Shortest Path
    // 无权单源最短路径

    private Graph G;
    private int s;  // 源

    private boolean[] visited;  // 记录是否访问过
    private int[] pre;  // 记录路径
    private int[] dis;  // 记录距离

    public USSSPath(Graph G, int s) {

        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        dis = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            pre[i] = -1;
            dis[i] = -1;
        }

        bfs(s);

    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        dis[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v))
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                    dis[w] = dis[v] + 1;
                }
        }
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public int dis(int t) {
        G.validateVertex(t);
        return dis[t];
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

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/bfs/bfsapplication";

        Graph g = new Graph(graphPath + "/g.txt");
        USSSPath ussspath = new USSSPath(g, 0);
        System.out.println("0 -> 6 : " + ussspath.path(6));
        System.out.println("0 -> 6 : " + ussspath.dis(6));
    }
}
