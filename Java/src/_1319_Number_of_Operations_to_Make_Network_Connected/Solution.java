package _1319_Number_of_Operations_to_Make_Network_Connected;

/**
 * Date: 2021/1/23 9:37
 * Content: 本质：求连通分量个数
 * 执行用时：4 ms, 在所有 Java 提交中击败了88.32%的用户
 * 内存消耗：53.8 MB, 在所有 Java 提交中击败了28.71%的用户
 */
public class Solution {

    public static final int N = 100010;

    static int[] p = new int[N];

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int makeConnected(int n, int[][] connections) {

        int m = connections.length;
        if (m < n - 1) return -1;

        for (int i = 0; i < n; i++) p[i] = i;  // 初始化并查集
        int cnt = n;  // 记录连通分量的个数
        for (int[] edge : connections) {
            int a = find(edge[0]), b = find(edge[1]);
            if (a != b) {
                p[a] = b;
                cnt--;
            }
        }

        return cnt == 1 ? 0 : cnt - 1;
    }

    public static void main(String[] args) {

//        // 1
//        int n = 4;
//        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
//        System.out.println((new Solution()).makeConnected(n, connections));

        // 2
        int n = 6;
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println((new Solution()).makeConnected(n, connections));
    }
}
