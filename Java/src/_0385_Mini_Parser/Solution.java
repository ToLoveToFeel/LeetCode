package _0385_Mini_Parser;

import java.util.List;

/**
 * Date: 2021/5/29 22:02
 */
public class Solution {

    static public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int u = 0;

    public NestedInteger deserialize(String s) {
        return dfs(s.toCharArray(), s);
    }

    private NestedInteger dfs(char[] cs, String s) {
        NestedInteger res = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public void setInteger(int value) {

            }

            @Override
            public void add(NestedInteger ni) {

            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        };
        if (cs[u] == '[') {
            u++;  // 跳过左括号
            while (cs[u] != ']') res.add(dfs(cs, s));
            u++;  // 跳过右括号
            if (u < cs.length && cs[u] == ',') u++;  // 跳过逗号
        } else {
            int k = u;
            while (k < cs.length && cs[k] != ',' && cs[k] != ']') k++;
            res.setInteger(Integer.parseInt(s.substring(u, k)));
            if (k < cs.length && cs[k] == ',') k++;  // 跳过逗号
            u = k;
        }
        return res;
    }
}
