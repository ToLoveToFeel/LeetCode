package _0000_classicalProblems._graph.dfs.dfsapplication;


import _0000_classicalProblems._graph.graphrepresentation.Graph;

public class BipartitionDetection {
    // 二部图检测算法
    private Graph G;
    private boolean[] visited;  // 记录是否访问过
    private int[] colors;
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                if (!dfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
    }

    // 返回是不是二部图
    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;

        for (int w : G.adj(v))
            if (!visited[w]) {
                if (!dfs(w, 1 - color))
                    return false;
            } else if (colors[v] == colors[w])  // v相邻的点w之前已经访问过，并且颜色和v一致，则不是二部图
                return false;
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/dfs/dfsapplication";

        Graph g = new Graph(graphPath + "/g.txt");
        BipartitionDetection bipartitionDetection = new BipartitionDetection(g);
        System.out.println(bipartitionDetection.isBipartite);
        // true

        Graph g3 = new Graph(graphPath + "/g3.txt");
        BipartitionDetection bipartitionDetection3 = new BipartitionDetection(g3);
        System.out.println(bipartitionDetection3.isBipartite);
        // false

        Graph g4 = new Graph(graphPath + "/g4.txt");
        BipartitionDetection bipartitionDetection4 = new BipartitionDetection(g4);
        System.out.println(bipartitionDetection4.isBipartite);
        // true
    }
}
