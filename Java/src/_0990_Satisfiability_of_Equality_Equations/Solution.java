package _0990_Satisfiability_of_Equality_Equations;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/17 21:16
 * Content:
 */
public class Solution {

    public boolean equationsPossible(String[] eq) {

        // 第一步：统计字母的个数，并将 eq 根据相等与否分为两个集合
        List<String> equalList = new ArrayList<>();
        List<String> unequalList = new ArrayList<>();
        for (String e : eq) {
            if (e.substring(1, 3).equals("==")) equalList.add(e);
            else unequalList.add(e);
        }
        // 第二步：使用并查集将所有相等的数据放在一起
        UnionFind uf = new UnionFind(26);
        for (String s : equalList)
            uf.unionElements(s.charAt(0) - 'a', s.charAt(3) - 'a');

        // 第三步：根据不相等的集合判断等式方程的可满足性：如果两个数据不相等但却在同一个集合中，则不合法
        for (String s : unequalList) {
            if (uf.isConnected(s.charAt(0) - 'a', s.charAt(3) - 'a'))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        String[] equations = {"c==c", "b==d", "x!=z"};  // true
//        String[] equations = {"a==b", "b!=c", "c==a"};  // false
        String[] equations = {"a==b", "b!=a"};  // false
        System.out.println((new Solution()).equationsPossible(equations));
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 合并
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
