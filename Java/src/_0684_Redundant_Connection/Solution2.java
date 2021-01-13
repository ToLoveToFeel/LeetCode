package _0684_Redundant_Connection;

import _0000_study._common.Output;

/**
 * Date: 2020/9/17 18:44
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了47.77%的用户
 */
public class Solution2 {

    public static final int N = 1010;

    static int[] p = new int[N];

    private int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public int[] findRedundantConnection(int[][] edges) {

        for (int i = 1; i <= edges.length; i++) p[i] = i;

        for (int[] edge : edges) {
            int a = find(edge[0]), b = find(edge[1]);
            if (a != b) p[a] = b;
            else return edge;
        }

        return new int[0];
    }

    public static void main(String[] args) {

//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};  // [2, 3]
        int[][] edges = {{4, 2}, {2, 3}, {3, 4}, {1, 2}, {3, 5}, {1, 6}, {6, 7}};  // [3, 4]
        int[] res = (new Solution2()).findRedundantConnection(edges);
        Output.OutputBasicArray1D(res);
    }
}
