package _0785_Is_Graph_Bipartite;

public class Solution {

    private boolean[] visited;  // 记录图是否访问过
    private int[] colors;  // 记录顶点染的颜色
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {

        int V = graph.length;  // 节点数目
        visited = new boolean[V];  // 默认false
        colors = new int[V];  // 默认为0
        this.graph = graph;

        for (int v = 0; v < V; v++)
            if (!visited[v])
                if (!dfs(v, 0))
                    return false;

        return true;
    }

    private boolean dfs(int v, int color){
        visited[v] = true;
        colors[v] = color;
        for (int w : graph[v])
            if (!visited[w]) {
                if (!dfs(w, 1 - color))
                    return false;
            }
            else if (colors[v] == colors[w])  // w已经染过色，判断w颜色和当前节点v染色是否相同，相同不是二分图
                return false;
        return true;
    }
}
