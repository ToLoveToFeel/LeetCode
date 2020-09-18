package _0000_study._graph._undirectedgraph.graphcutpoints;

import _0000_study._graph.graphrepresentation.Graph;

import java.util.HashSet;

public class FindCutPoints {
    // 寻找图中割点算法
    private Graph G;
    private boolean[] visited;

    private int[] ord;  // ord[v]表示顶点v在DFS的访问顺序
    private int[] low;  // low[v]表示在DFS中，顶点v所能到达的最小ord值
    private int cnt;  // 访问顺序

    private HashSet<Integer> res;  // 存储割点

    public FindCutPoints(Graph G) {

        this.G = G;
        res = new HashSet<>();
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

        int child = 0;

        for (int w : G.adj(v))
            if (!visited[w]) {  // v的相邻节点没有访问过
                dfs(w, v);
                low[v] = Math.min(low[v], low[w]);

                if (v != parent && low[w] >= ord[v])  // 考虑边vw
                    res.add(v);

                child++;
                if (v == parent && child > 1)
                    res.add(v);
            } else if (w != parent)  // // w已经访问过，并且w不是v的父节点
                low[v] = Math.min(low[v], low[w]);
    }

    public HashSet<Integer> result() {
        return res;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/graphcutpoints";

        Graph g = new Graph(graphPath + "/g.txt");
        FindCutPoints fc = new FindCutPoints(g);
        System.out.println("Cut Points in g : " + fc.result());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        FindCutPoints fc2 = new FindCutPoints(g2);
        System.out.println("Cut Points in g2 : " + fc2.result());

        Graph tree = new Graph(graphPath + "/tree.txt");
        FindCutPoints fc3 = new FindCutPoints(tree);
        System.out.println("Cut Points in tree : " + fc3.result());
    }
}
