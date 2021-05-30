package _0399_Evaluate_Division;

import java.util.*;

/**
 * Date: 2021/1/6 9:53
 * Content: https://www.acwing.com/activity/content/code/content/524881/
 * 执行用时：6 ms, 在所有 Java 提交中击败了5.92%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了5.05%的用户
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Set<String> vers = new HashSet<>();  // 顶点
        Map<String, Map<String, Double>> d = new HashMap<>();  // 图

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            double c = values[i];
            if (!d.containsKey(a)) d.put(a, new HashMap<>());
            d.get(a).put(b, c);
            if (!d.containsKey(b)) d.put(b, new HashMap<>());
            d.get(b).put(a, 1 / c);
            vers.add(a);
            vers.add(b);
        }

        // Floyd
        for (String k : vers)
            for (String i : vers)
                for (String j : vers)
                    if (d.get(i).getOrDefault(k, 0.0) != 0 &&
                            d.get(k).getOrDefault(j, 0.0) != 0)
                        d.get(i).put(j, d.get(i).get(k) * d.get(k).get(j));


        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> q : queries) {
            String a = q.get(0), b = q.get(1);
            if (d.containsKey(a) && d.get(a).getOrDefault(b, 0.0) != 0) res[index++] = d.get(a).get(b);
            else res[index++] = -1;
        }

        return res;
    }

    private static List<List<String>> build(String[][] s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            List<String> e = new ArrayList<>();
            for (int j = 0; j < s[i].length; j++) e.add(s[i][j]);
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {

        String[][] s = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        List<List<String>> equations = build(s);
        double[] values = {1.5, 2.5, 5.0};
        String[][] s1 = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
        List<List<String>> queries = build(s1);

        double[] res = (new Solution()).calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }
}
