package _0000_classicalProblems._graph._undirectedgraph.dfs.dfsapplication;

import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class SingleSourcePath {
    // 单源路径问题
    private Graph G;
    private int s;  // 源
    private int[] pre;  // 记录当前节点来自于哪个节点，同时记录是否访问到的信息，未访问到是-1

    public SingleSourcePath(Graph G, int s) {

        this.G = G;
        this.s = s;
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        dfs(s, s);
    }

    private void dfs(int v, int parent) {
        pre[v] = parent;
        for (int w : G.adj(v))
            if (pre[w] == -1)
                dfs(w, v);
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return pre[t] != -1;
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t))
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
        SingleSourcePath ssp = new SingleSourcePath(g, 0);
        System.out.println("0 --> 6 : " + ssp.path(6));
        System.out.println("0 --> 5 : " + ssp.path(5));
    }
}
