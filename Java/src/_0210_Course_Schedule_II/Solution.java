package _0210_Course_Schedule_II;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2021/1/31 11:06
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了76.64%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了40.87%的用户
 */
public class Solution {

    public int[] findOrder(int n, int[][] edges) {

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] d = new int[n];  // 存储入度
        for (int[] e : edges) {
            int b = e[0], a = e[1];
            g.get(a).add(b);
            d[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.add(i);

        int[] res = new int[n];
        int cnt = 0;
        while (!q.isEmpty()) {
            int a = q.remove();
            res[cnt++] = a;
            for (int b : g.get(a))
                if (--d[b] == 0)
                    q.add(b);
        }
        if (cnt < n) return new int[]{};
        return res;
    }

    public static void main(String[] args) {

        // [0, 1, 2, 3]
        int n = 4;
        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = (new Solution()).findOrder(n, edges);
        Output.OutputBasicArray1D(res);
    }
}
