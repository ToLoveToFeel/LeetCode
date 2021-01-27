package _1579_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable;

/**
 * Date: 2021/1/27 10:35
 * Content:
 * 执行用时：13 ms, 在所有 Java 提交中击败了98.97%的用户
 * 内存消耗：78.3 MB, 在所有 Java 提交中击败了96.91%的用户
 */
public class Solution {

    private static int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }

    private static boolean merge(int[] p, int a, int b) {
        a = find(p, a);
        b = find(p, b);
        if (a != b) {
            p[a] = b;
            return true;
        }
        return false;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int[] p1 = new int[n + 1], p2 = new int[n + 1];  // 创建两个并查集，p1对应Alice，p2对应Bob
        for (int i = 1; i <= n; i++) {  // 初始化并查集
            p1[i] = i;
            p2[i] = i;
        }

        int res = 0;
        int cnt1 = n, cnt2 = n;  // 代表Alice和Bob连通分量的个数
        // 考虑第三种类型的边
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (merge(p1, e[1], e[2])) {
                    merge(p2, e[1], e[2]);
                    cnt1--;
                    cnt2--;
                } else res++;
            }
        }

        // 考虑第一、二种类型的边
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (merge(p1, e[1], e[2])) cnt1--;
                else res++;
            } else if (e[0] == 2) {
                if (merge(p2, e[1], e[2])) cnt2--;
                else res++;
            }
        }

        if (cnt1 != 1 || cnt2 != 1) return -1;  // 说明Alice或者Bob不连通
        return res;
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        System.out.println((new Solution()).maxNumEdgesToRemove(n, edges));  // 2
    }
}
