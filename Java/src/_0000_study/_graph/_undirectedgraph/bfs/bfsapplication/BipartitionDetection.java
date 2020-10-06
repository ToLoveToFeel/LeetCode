package _0000_study._graph._undirectedgraph.bfs.bfsapplication;

import _0000_study._graph.graphrepresentation.Graph;
import _0000_study._graph.util.FilePrefix;

import java.util.LinkedList;
import java.util.Queue;

public class BipartitionDetection {
    // BFS判断二部图
    private Graph G;
    private boolean[] visited;  // 记录是否访问过
    private int[] colors;  // 记录当前节点来自于哪个节点
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (!bfs(v)) {
                    isBipartite = false;
                    break;
                }
    }

    private boolean bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        colors[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v))
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    colors[w] = 1 - colors[v];
                } else if (colors[w] == colors[v])  // v相邻的点w之前已经访问过，并且颜色和v一致，则不是二部图
                    return false;
        }
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) {
        String graphPath = FilePrefix.pathPrefix + "_undirectedgraph/bfs/bfsapplication";

        Graph g = new Graph(graphPath + "/g2.txt");
        BipartitionDetection bipartitionDetection = new BipartitionDetection(g);
        System.out.println(bipartitionDetection.isBipartite);
        // true

        Graph g2 = new Graph(graphPath + "/g4.txt");
        BipartitionDetection bipartitionDetection2 = new BipartitionDetection(g2);
        System.out.println(bipartitionDetection2.isBipartite);
        // false

        Graph g3 = new Graph(graphPath + "/g5.txt");
        BipartitionDetection bipartitionDetection3 = new BipartitionDetection(g3);
        System.out.println(bipartitionDetection3.isBipartite);
        //true
    }
}
