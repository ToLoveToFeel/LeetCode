package _0726_Number_of_Atoms;

import java.util.TreeMap;

/**
 * Date: 2021/7/5 10:13
 * 执行用时：4 ms, 在所有 Java 提交中击败了97.14%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了85.36%的用户
 */
public class Solution {

    int u = 0;

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> t = dfs(formula.toCharArray(), formula);
        StringBuilder sb = new StringBuilder();
        for (String key : t.keySet()) {
            sb.append(key);
            if (t.get(key) > 1) sb.append(t.get(key));
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> dfs(char[] s, String str) {
        TreeMap<String, Integer> res = new TreeMap<>();
        while (u < s.length) {
            if (s[u] == '(') {
                u++;
                TreeMap<String, Integer> t = dfs(s, str);
                u++;
                int cnt = 1, k = u;
                while (k < s.length && s[k] >= '0' && s[k] <= '9') k++;
                if (k > u) {
                    cnt = Integer.parseInt(str.substring(u, k));
                    u = k;
                }
                for (String key : t.keySet())
                    res.put(key, res.getOrDefault(key, 0) + t.get(key) * cnt);
            } else if (s[u] == ')') {
                break;
            } else {
                int k = u + 1;
                while (k < s.length && s[k] >= 'a' && s[k] <= 'z') k++;
                String key = str.substring(u, k);
                u = k;
                int cnt = 1;
                while (k < s.length && s[k] >= '0' && s[k] <= '9') k++;
                if (k > u) {
                    cnt = Integer.parseInt(str.substring(u, k));
                    u = k;
                }
                res.put(key, res.getOrDefault(key, 0) + cnt);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).countOfAtoms("H2O"));  // H2O
        System.out.println((new Solution()).countOfAtoms("Mg(OH)2"));  // H2MgO2
        System.out.println((new Solution()).countOfAtoms("K4(ON(SO3)2)2"));  // K4N2O14S4
    }
}
