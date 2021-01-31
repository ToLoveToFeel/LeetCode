package _0207_Course_Schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date: 2021/1/31 10:55
 * Content:
 * 执行用时：5 ms, 在所有 Java 提交中击败了72.23%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了22.93%的用户
 */
public class Solution {

    public boolean canFinish(int n, int[][] edges) {

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] d = new int[n];  // 存储入度
        for (int[] e : edges) {
            int b = e[1], a = e[0];
            g.get(a).add(b);
            d[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (d[i] == 0)
                q.add(i);

        int cnt = 0;
        while (!q.isEmpty()) {
            int a = q.remove();
            cnt++;
            for (int b : g.get(a))
                if (--d[b] == 0)
                    q.add(b);
        }
        return cnt == n;
    }

    public static void main(String[] args) {

//        int n = 2;
//        int[][] edges = {{1, 0}};
//        System.out.println((new Solution()).canFinish(n, edges));  // true

        int n = 2;
        int[][] edges = {{1, 0}, {0, 1}};
        System.out.println((new Solution()).canFinish(n, edges));  // false
    }
}
