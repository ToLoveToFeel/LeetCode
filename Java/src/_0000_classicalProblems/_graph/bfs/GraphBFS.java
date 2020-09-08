package _0000_classicalProblems._graph.bfs;

import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];  // 默认false

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                bfs(v);
    }

    private void bfs(int s) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);

            for (int w : G.adj(v))
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/bfs";
        Graph g = new Graph(graphPath + "/g.txt");
        GraphBFS graphBFS = new GraphBFS(g);
        System.out.println("BFS order : " + graphBFS.order());
    }
}
