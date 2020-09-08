package _0000_classicalProblems._graph._undirectedgraph.dfs.dfsapplication;

import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class Path {
    // 路径问题
    private Graph G;
    private int s;  // 源
    private int t;  // 目的

    private int[] pre;  // 记录当前节点来自于哪个节点未访问到是-1
    private boolean[] visited;  // 记录节点是否访问过，默认false

    public Path(Graph G, int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);

        this.G = G;
        this.s = s;
        this.t = t;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        dfs(s, s);
    }

    // 返回从v点出发能否到达目标（t）
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == t)
            return true;

        for (int w : G.adj(v))
            if (!visited[w]) {
                if (dfs(w, v))
                    return true;
            }
        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }

    public Iterable<Integer> path() {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnected())
            return res;

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
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/dfs/dfsapplication";

        Graph g = new Graph(graphPath + "/g.txt");
        Path path = new Path(g, 0, 6);
        System.out.println("0 -> 6 : " + path.path());

        Path path2 = new Path(g, 0, 5);
        System.out.println("0 -> 5 : " + path2.path());

        Path path3 = new Path(g, 0, 1);
        System.out.println("0 -> 1 : " + path3.path());
    }
}

