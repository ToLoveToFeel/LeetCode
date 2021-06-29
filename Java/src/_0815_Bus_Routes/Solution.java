package _0815_Bus_Routes;

import java.util.*;

/**
 * Date: 2021/6/28 10:18
 * 执行用时：69 ms, 在所有 Java 提交中击败了47.08%的用户
 * 内存消耗：60.9 MB, 在所有 Java 提交中击败了55.06%的用户
 */
public class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        HashMap<Integer, List<Integer>> g = new HashMap<>();  // 倒排索引：(车站，经过该车站的公交路线)
        int[] dist = new int[n];  // 从source到公交路线需要做的公交车数量
        Arrays.fill(dist, (int) 1e8);
        Queue<Integer> q = new LinkedList<>();  // 存储公交路线
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                if (x == source) {
                    dist[i] = 1;
                    q.add(i);
                }
                if (!g.containsKey(x)) g.put(x, new ArrayList<>());
                g.get(x).add(i);
            }
        }

        while (!q.isEmpty()) {
            int t = q.remove();

            for (int x : routes[t]) {
                if (target == x) return dist[t];
                if (!g.containsKey(x)) continue;  // 后面从g中删除了x, 因此这里需要判断，否则下面会报错
                for (int y : g.get(x)) {
                    if (dist[y] > dist[t] + 1) {
                        dist[y] = dist[t] + 1;
                        q.add(y);
                    }
                }
                g.remove(x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        System.out.println((new Solution()).numBusesToDestination(routes, 15, 12));  // -1
    }
}
