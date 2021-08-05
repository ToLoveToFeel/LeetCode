package _0802_Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2021/8/5 11:03
 * Content:
 */
public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] d = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n; i++)
            for (int b : graph[i]) {
                int a = i;
                g.get(b).add(a);
                d[a]++;  // a的入度增加一
            }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int t = q.remove();
            if (g.get(t).isEmpty()) continue;
            for (int i : g.get(t))
                if (--d[i] == 0)
                    q.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                res.add(i);
        return res;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {},
        };
        System.out.println((new Solution()).eventualSafeNodes(graph));  // [2, 4, 5, 6]
    }
}
