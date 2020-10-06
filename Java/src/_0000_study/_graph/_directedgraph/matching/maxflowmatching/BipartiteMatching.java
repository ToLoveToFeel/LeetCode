package _0000_study._graph._directedgraph.matching.maxflowmatching;

import _0000_study._graph._directedgraph.maxflow.MaxFlow;
import _0000_study._graph._undirectedgraph.dfs.dfsapplication.BipartitionDetection;
import _0000_study._graph.graphrepresentation.Graph;
import _0000_study._graph.graphrepresentation.WeightedGraph;
import _0000_study._graph.util.FilePrefix;

public class BipartiteMatching {
    // 使用最大流算法解决二部图的最大匹配问题
    private Graph G;
    private int maxMatching;

    public BipartiteMatching(Graph G) {

        BipartitionDetection bd = new BipartitionDetection(G);
        if (!bd.isBipartite())
            throw new IllegalArgumentException("BipartiteMatching only works for bipartite graph.");

        this.G = G;

        int[] colors = bd.colors();

        // 源点为 V, 汇点为 V + 1
        WeightedGraph network = new WeightedGraph(G.V() + 2, true);
        for (int v = 0; v < G.V(); v++) {
            if (colors[v] == 0) network.addEdge(G.V(), v, 1);
            else network.addEdge(v, G.V() + 1, 1);

            for (int w : G.adj(v))
                if (v < w) {
                    if (colors[v] == 0) network.addEdge(v, w, 1);
                    else network.addEdge(w, v, 1);
                }
        }

        MaxFlow maxFlow = new MaxFlow(network, G.V(), G.V() + 1);
        maxMatching = maxFlow.result();
    }

    public int maxMatching() {
        return maxMatching;
    }

    public boolean isPerfectMatching() {
        return maxMatching * 2 == G.V();
    }

    public static void main(String[] args) {
        String graphPath = FilePrefix.pathPrefix + "_directedgraph/matching";

        Graph g = new Graph(graphPath + "/g.txt");
        BipartiteMatching bm = new BipartiteMatching(g);
        System.out.println(bm.maxMatching());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        BipartiteMatching bm2 = new BipartiteMatching(g2);
        System.out.println(bm2.maxMatching());
    }
}
