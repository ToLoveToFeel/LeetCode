package _0834_Sum_of_Distances_in_Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/10/6 10:49
 * Content:
 */
public class Solution2 {

    private Set<Integer>[] graph;

    private int[] nodeNum; // node[i]：以 i 为根的子树节点个数（包含节点 i）

    private int[] result;  // result[i]代表：节点i所在的子树中的节点到节点i的距离和

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new Set[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        nodeNum = new int[N];
        result = new int[N];
        postOrder(0, -1);
        preOrder(0, -1, N);
        return result;
    }

    private void postOrder(int root, int parent) {
        nodeNum[root] = 1;
        for (int next : graph[root]) {
            if (next != parent) {
                postOrder(next, root);
                nodeNum[root] += nodeNum[next];
                result[root] += result[next] + nodeNum[next];
            }
        }
    }

    private void preOrder(int root, int parent, int n) {
        for (int next : graph[root]) {
            if (next != parent) {
                result[next] = result[root] - 2 * nodeNum[next] + n;
                preOrder(next, root, n);
            }
        }
    }

    public static void main(String[] args) {
//        int N = 6;
//        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
//        int N = 1;
//        int[][] edges = {};
        int N = 7;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 6}};
        int[] res = (new Solution2()).sumOfDistancesInTree(N, edges);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
