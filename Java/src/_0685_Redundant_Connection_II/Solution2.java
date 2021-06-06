package _0685_Redundant_Connection_II;

import java.util.*;

/**
 * Date: 2021/6/6 12:28
 */
public class Solution2 {

    int n;
    boolean[] st1, st, in_stk, in_cycle;  // 树中找环需要的数组
    boolean[] st2;
    Deque<Integer> stk = new ArrayDeque<>();
    List<List<Integer>> g = new ArrayList<>();

    public int[] findRedundantDirectedConnection(int[][] edges) {
        n = edges.length;
        st1 = new boolean[n + 1]; st2 = new boolean[n + 1]; st = new boolean[n + 1];
        in_stk = new boolean[n + 1]; in_cycle = new boolean[n + 1];
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        work1(edges);
        work2(edges);

        for (int i = n - 1; i >= 0; i--)
            if (st1[i] && st2[i])
                return edges[i];
        for (int i = n - 1; i >= 0; i--)
            if (st1[i] || st2[i])
                return edges[i];
        return new int[]{};
    }

    private void work1(int[][] edges) {
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            g.get(a).add(b);
        }

        for (int i = 1; i <= n; i++)
            if (!st[i] && dfs(i))
                break;

        for (int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (in_cycle[a] && in_cycle[b])
                st1[i] = true;
        }
    }

    private boolean dfs(int u) {
        st[u] = true;
        stk.push(u); in_stk[u] = true;

        for (int x : g.get(u)) {
            if (!st[x]) {
                if (dfs(x)) return true;
            } else if (in_stk[x]) {
                while (stk.peek() != x) {
                    in_cycle[stk.peek()] = true;
                    stk.pop();
                }
                in_cycle[x] = true;
                return true;
            }
        }

        stk.pop(); in_stk[u] = false;
        return false;
    }

    private void work2(int[][] edges) {
        int[] p = new int[n + 1];
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];  // 第i条边(a, b)
            if (p[b] != -1) {
                st2[p[b]] = st2[i] = true;
                break;
            } else p[b] = i;
        }
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString((new Solution()).findRedundantDirectedConnection(edges)));  // [2, 3]
    }
}
