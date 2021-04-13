package _0785_Is_Graph_Bipartite;

/**
 * Date: 2021/4/13 8:59
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了65.81%的用户
 */
public class Solution {

    int[] color;  // 0代表当前节点还未染色, 1、2分别表示两种颜色
    int[][] g;

    public boolean isBipartite(int[][] graph) {

        g = graph;
        int n = g.length;  // 图中顶点数
        color = new int[n];
        for (int i = 0; i < n; i++)
            if (color[i] == 0)
                if (!dfs(i, 1))
                    return false;
        return true;
    }

    private boolean dfs(int u, int c) {
        color[u] = c;
        for (int w : g[u]) {
            if (color[w] == 0) {
                if (!dfs(w, 3 - c)) return false;
            } else if (color[w] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
//        System.out.println((new Solution()).isBipartite(graph));  // false
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println((new Solution()).isBipartite(graph));  // true
    }
}
