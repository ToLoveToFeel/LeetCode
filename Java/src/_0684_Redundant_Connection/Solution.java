package _0684_Redundant_Connection;

/**
 * Date: 2020/9/17 18:44
 * Content:
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);  // 节点数 == 边数
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (!uf.isConnected(node1, node2))
                uf.unionElements(node1, node2);
            else
                return edge;
        }
        throw new IllegalArgumentException("Input Error");
    }

    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges = {{4, 2}, {2, 3}, {3, 4}, {1, 2}, {3, 5}, {1, 6}, {6, 7}};
        int[] res = (new Solution()).findRedundantConnection(edges);
        System.out.println(res[0] + " - " + res[1]);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    // 构造函数
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 合并
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else {
            parent[pRoot] = parent[qRoot];
            rank[qRoot] += 1;
        }
    }
}
