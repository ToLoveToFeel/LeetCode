package _0834_Sum_of_Distances_in_Tree;

import java.util.Arrays;

/**
 * Date: 2020/10/6 10:49
 * Content:
 * Floyed 算法
 * 算法正确，但是提交不通过，原因：超过内存限制
 */
public class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dis = new int[N][N];
        for (int v = 0; v < N; v++)
            Arrays.fill(dis[v], Integer.MAX_VALUE);
        for (int v = 0; v < N; v++)  // 最后距离相加时，需要自身到自身距离为0
            dis[v][v] = 0;
        for (int[] edge : edges) {
            dis[edge[0]][edge[1]] = 1;
            dis[edge[1]][edge[0]] = 1;
        }

        for (int t = 0; t < N; t++)
            for (int v = 0; v < N; v++)
                for (int w = 0; w < N; w++)
                    if (dis[v][t] != Integer.MAX_VALUE && dis[t][w] != Integer.MAX_VALUE
                            && dis[v][t] + dis[t][w] < dis[v][w])
                        dis[v][w] = dis[v][t] + dis[t][w];

        int[] res = new int[N];
        for (int v = 0; v < N; v++)  // 不需要判断 dis 中的值是否为最大值，因为是连通图
            for (int w = 0; w < N; w++)
                res[v] += dis[v][w];

        return res;
    }

    public static void main(String[] args) {
//        int N = 6;
//        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int N = 1;
        int[][] edges = {};
        int[] res = (new Solution()).sumOfDistancesInTree(N, edges);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
