package _0000_study._graph._undirectedgraph.graphbridges;

import _0000_study._graph.graphrepresentation.Edge;
import _0000_study._graph.graphrepresentation.Graph;

import java.util.ArrayList;

public class FindBridges {
    // 寻找图中桥算法
    private Graph G;
    private boolean[] visited;

    private int[] ord;  // ord[v]表示顶点v在DFS的访问顺序
    private int[] low;  // low[v]表示在DFS中，顶点v所能到达的最小ord值
    private int cnt;  // 访问顺序

    private ArrayList<Edge> res;  // 存储桥

    public FindBridges(Graph G) {

        this.G = G;
        res = new ArrayList<>();
        visited = new boolean[G.V()];
        ord = new int[G.V()];
        low = new int[G.V()];
        cnt = 0;

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v, v);
    }

    private void dfs(int v, int parent) {  // 抓住当前考虑的点是 v
        visited[v] = true;
        ord[v] = cnt;
        low[v] = ord[v];
        cnt++;

        for (int w : G.adj(v))
            if (!visited[w]) {  // v的相邻节点没有访问过
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] > ord[v])  // 考虑边vw
                    res.add(new Edge(v, w));
            } else if (w != parent)  // // w已经访问过，并且w不是v的父节点
                low[v] = Math.min(low[v], low[w]);
    }

    public ArrayList<Edge> result() {
        return res;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/graphbridges";

        Graph g = new Graph(graphPath + "/g.txt");
        FindBridges fb = new FindBridges(g);
        System.out.println("Bridges in g : " + fb.result());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        FindBridges fb2 = new FindBridges(g2);
        System.out.println("Bridges in g2 : " + fb2.result());

        Graph g3 = new Graph(graphPath + "/g3.txt");
        FindBridges fb3 = new FindBridges(g3);
        System.out.println("Bridges in g3 : " + fb3.result());

        Graph tree = new Graph(graphPath + "/tree.txt");
        FindBridges fb_tree = new FindBridges(tree);
        System.out.println("Bridges in tree : " + fb_tree.result());
    }

}
