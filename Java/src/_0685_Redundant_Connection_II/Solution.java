package _0685_Redundant_Connection_II;

/**
 * Date: 2020/9/17 9:43
 * Content:
 */
public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];  // 记录每个节点的父节点
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        // 以下两种情况可能出现一种，也可能同时出现（子节点指向其非根父节点）
        int conflict = -1;  // 导致冲突的边
        int cycle = -1;  // 导致形成环的边
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.isConnected(node1, node2)) {
                    cycle = i;
                } else {
                    uf.unionElements(node1, node2);
                }
            }
        }

        if (conflict < 0) {  // 如果形成环，并且没有冲突，说明多余的边指向根节点
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            // 如果有冲突，
            // 但有没有环和两个因素有关系：（1）图本身就没有环 （2）图中有环，但是先遍历到冲突，无法识别到环；先遍历到环还可以识别到冲突
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {  // 同时有环
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {  // 同时无环
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{4, 2}, {2, 3}, {3, 4}, {1, 2}, {3, 5}, {1, 6}, {6, 7}};
        int[] res = (new Solution()).findRedundantDirectedConnection(edges);
        System.out.println(res[0] + " -> " + res[1]);
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
            parent[p] = parent[parent[p]];  // 路径压缩
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
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
