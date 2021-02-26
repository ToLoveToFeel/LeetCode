package _0332_Reconstruct_Itinerary;

import _0000_study._common.Build;

import java.util.*;

/**
 * Created by WXX on 2021/2/26 10:28
 * 执行用时：8 ms, 在所有 Java 提交中击败了59.50%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了57.04%的用户
 */
public class Solution {

    Map<String, LinkedList<String>> g = new HashMap<>();  // 邻接表
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> e : tickets) {
            String a = e.get(0), b = e.get(1);
            LinkedList<String> t = g.getOrDefault(a, new LinkedList<>());
            t.add(b);
            g.put(a, t);
        }
        for (String k : g.keySet()) Collections.sort(g.get(k));  // 为了保证字典序最小

        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String u) {
        LinkedList<String> t = g.get(u);
        while (t != null && !t.isEmpty()) {
            String ver = t.get(0);
            t.removeFirst();
            dfs(ver);
        }
        ans.add(u);
    }

    public static void main(String[] args) {

        List<List<String>> tickets = Build.build(
                new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}});
        System.out.println((new Solution()).findItinerary(tickets));  // [JFK, MUC, LHR, SFO, SJC]
    }
}
