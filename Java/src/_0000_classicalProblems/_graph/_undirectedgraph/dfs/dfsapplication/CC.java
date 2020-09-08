package _0000_classicalProblems._graph._undirectedgraph.dfs.dfsapplication;

import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;

public class CC {
    // 计算连通分量个数
    private Graph G;
    private int[] visited;  // 不同的连通分量visited值不同，从0开始，-1代表还未访问该节点
    private int cccount = 0;  // 记录连通分量个数

    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < G.V(); i++)
            visited[i] = -1;

        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                dfs(v, cccount);
                cccount++;
            }
    }

    public void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w : G.adj(v))
            if (visited[w] == -1)
                dfs(w, ccid);
    }

    // 返回连通分量个数
    public int count() {
        return cccount;
    }

    // 判断两个节点是否在同一个连通分量中
    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    // 返回不同连通分量包含的节点
    ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            res[visited[v]].add(v);
        return res;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_undirectedgraph/dfs/dfsapplication";

        Graph g = new Graph(graphPath + "/g.txt");
        CC cc = new CC(g);
        System.out.println(cc.count());

        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(5, 6));

        ArrayList<Integer>[] comp = cc.components();
        for (int ccid = 0; ccid < comp.length; ccid++) {
            System.out.print(ccid + " : ");
            for (int w : comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }
}
