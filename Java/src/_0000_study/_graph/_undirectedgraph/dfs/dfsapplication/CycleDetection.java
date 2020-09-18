package _0000_study._graph._undirectedgraph.dfs.dfsapplication;

import _0000_study._graph.graphrepresentation.Graph;

public class CycleDetection {
    // 环检测算法
    private Graph G;
    private boolean[] visited;  // 记录是否访问过
    private boolean hasCycle = false;

    public CycleDetection(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
    }

    // 返回是否有环
    private boolean dfs(int v, int parent) {
        visited[v] = true;

        for (int w : G.adj(v))
            if (!visited[w]) {
                if (dfs(w, v))
                    return true;
            } else if (w != parent)  // w已经访问过，并且w不是v的父节点，则说明有环
                return true;
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/dfs/dfsapplication";

        Graph g = new Graph(graphPath + "/g.txt");
        CycleDetection cycleDetection = new CycleDetection(g);
        System.out.println(cycleDetection.hasCycle());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        CycleDetection cycleDetection2 = new CycleDetection(g2);
        System.out.println(cycleDetection2.hasCycle());
    }
}
