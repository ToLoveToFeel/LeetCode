package _0000_study._graph._directedgraph.matching.hungariandfs;

import _0000_study._graph._undirectedgraph.dfs.dfsapplication.BipartitionDetection;
import _0000_study._graph.graphrepresentation.Graph;
import _0000_study._graph.util.FilePrefix;

import java.util.*;

public class Hungarian {

    private Graph G;
    private int maxMatching;
    private int matching[];
    private boolean visited[];

    public Hungarian(Graph G) {

        BipartitionDetection bd = new BipartitionDetection(G);
        if (!bd.isBipartite())
            throw new IllegalArgumentException("BipartiteMatching only works for bipartite graph.");

        this.G = G;

        int[] colors = bd.colors();

        matching = new int[G.V()];
        Arrays.fill(matching, -1);

        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (colors[v] == 0 && matching[v] == -1) {
                Arrays.fill(visited, false);
                if (dfs(v)) maxMatching++;
            }
    }

    private boolean dfs(int v) {

        visited[v] = true;
        for (int u : G.adj(v))
            if (!visited[u]) {
                visited[u] = true;
                if (matching[u] == -1 || dfs(matching[u])) {
                    matching[u] = v;
                    matching[v] = u;
                    return true;
                }
            }
        return false;
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
        Hungarian hungarian = new Hungarian(g);
        System.out.println(hungarian.maxMatching());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        Hungarian hungarian2 = new Hungarian(g2);
        System.out.println(hungarian2.maxMatching());
    }
}
