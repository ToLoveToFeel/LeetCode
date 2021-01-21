package _1489_Find_Critical_and_Pseudo_Critical_Edges_in_Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/1/21 13:43
 * Content: kruskal算法
 * <p>
 * 执行用时：34 ms, 在所有 Java 提交中击败了27.10%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了50.47%的用户
 */
public class Solution {

    public static final int N = 1010;

    static int[] p = new int[N];

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static class Edges implements Comparable<Edges> {
        int a, b, w;
        int index;  // 排序前边在数组中的位置

        public Edges(int a, int b, int w, int index) {
            this.a = a;
            this.b = b;
            this.w = w;
            this.index = index;
        }

        @Override
        public int compareTo(Edges o) {
            return this.w - o.w;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        for (int i = 0; i < n; i++) p[i] = i;  // 并查集初始化

        int m = edges.length;  // 边数
        Edges[] t = new Edges[m];
        for (int i = 0; i < m; i++) t[i] = new Edges(edges[i][0], edges[i][1], edges[i][2], i);
        // kruskal算法，得到mst权值之和
        Arrays.sort(t);
        int min_cost = 0;
        for (int i = 0; i < m; i++) {
            int a = t[i].a, b = t[i].b, w = t[i].w;
            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                min_cost += w;
            }
        }

        // 依次考察每条边，得到结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) res.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            /**
             * 判断是否为关键边：将这条边从路径中去除，然后利用最小生成树算法求路径和，
             * 如果不连通 或者 路径和大于min_cost，那么这条边就是关键边
             */
            for (int j = 0; j < n; j++) p[j] = j;  // 重新初始化并查集
            int cost = 0, cnt = 0;  // cost记录去掉边edges[i]得到的mst权值之和，cnt记录mst中 点数
            for (int j = 0; j < m; j++) {
                if (j == i) continue;
                int a = t[j].a, b = t[j].b, w = t[j].w;
                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    cost += w;
                    cnt++;
                }
            }
            // 去掉edge[i]后不连通 或者 路径和大于min_cost
            if (cnt != n - 1 || (cnt == n - 1 && cost > min_cost)) {
                res.get(0).add(t[i].index);
                continue;  // 说明这条边是关键边，不用再判断是否为非关键边
            }

            /**
             * 判断是否是非关键边：首先调用上面判断其是不是关键边，如果删掉edge[i]之后路径和不变，则说明其可以没有。(可无)
             * 那么怎么判断edge[i]可能会出现在某些最小生成树呢?
             * 只需要一开始将就edge[i]加入到最小生成树中，然后使用算法求路径和。如果路径和等于min_cost，则其就是
             * 伪关键边(可有)，否则就不是。(另外注意：如果能运行下面内容，说明cost == min_cost)
             */
            for (int j = 0; j < n; j++) p[j] = j;  // 重新初始化并查集
            cost = 0;  // cost记录首先就加入edges[i]得到的mst权值之和
            cnt = 0;  // cnt记录mst中 点数
            // 首先加入edges[i]
            int a = t[i].a, b = t[i].b, w = t[i].w;
            p[find(a)] = find(b);
            cost += w;
            cnt++;
            for (int j = 0; j < m; j++) {
                a = t[j].a;
                b = t[j].b;
                w = t[j].w;

                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    cost += w;
                    cnt++;
                }
            }
            if (cost == min_cost) res.get(1).add(t[i].index);
        }

        return res;
    }

    public static void main(String[] args) {

        // [[0, 1], [2, 3, 4, 5]]
        int n = 5;
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}};
        System.out.println((new Solution()).findCriticalAndPseudoCriticalEdges(n, edges));

//        // [[], [0, 1, 2, 3]]
//        int n = 4;
//        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}};
//        System.out.println((new Solution()).findCriticalAndPseudoCriticalEdges(n, edges));
    }
}
