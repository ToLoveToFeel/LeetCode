package _0433_Minimum_Genetic_Mutation;

import java.util.*;

/**
 * Date: 2021/6/1 20:01
 * 执行用时：9 ms, 在所有 Java 提交中击败了6.06%的用户
 * 内存消耗：37 MB, 在所有 Java 提交中击败了5.03%的用户
 */
public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> S = new HashSet<>();
        Collections.addAll(S, bank);
        HashMap<String, Integer> dist = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        dist.put(start, 0);
        char[] chs = {'A', 'T', 'G', 'C'};
        while (!q.isEmpty()) {
            String t = q.remove();
            for (int i = 0; i < t.length(); i++) {
                for (char c : chs) {
                    String s = t.substring(0, i) + c + t.substring(i + 1);
                    if (S.contains(s) && !dist.containsKey(s)) {
                        dist.put(s, dist.get(t) + 1);
                        if (end.equals(s)) return dist.get(s);
                        q.add(s);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] bank = {"AACCGGTA"};
        System.out.println((new Solution()).minMutation("AACCGGTT", "AACCGGTA", bank));  // 1
    }
}
