package _0690_Employee_Importance;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/5/3 18:03
 */
public class Solution {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    HashMap<Integer, Employee> hash = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee p : employees) hash.put(p.id, p);
        return dfs(id);
    }

    private int dfs(int id) {
        Employee p = hash.get(id);
        int res = p.importance;
        for (int son : p.subordinates)
            res += dfs(son);
        return res;
    }
}
