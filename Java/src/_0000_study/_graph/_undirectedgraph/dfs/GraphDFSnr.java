package _0000_study._graph._undirectedgraph.dfs;

import _0000_study._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphDFSnr {
    // 深度优先遍历非递归算法
    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();

    public GraphDFSnr(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    private void dfs(int v) {

        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            pre.add(cur);
            for (int w : G.adj(cur))
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/dfs";
        Graph g = new Graph(graphPath + "/g.txt");
        GraphDFSnr graphDFSnr = new GraphDFSnr(g);
        System.out.println(graphDFSnr.pre());
    }
}
