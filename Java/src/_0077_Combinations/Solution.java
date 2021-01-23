package _0077_Combinations;

import java.util.*;

/**
 * 时间复杂度：O(n^k)
 * 空间复杂度：O(k)
 */
class Solution {

    private ArrayList<List<Integer>> res = new ArrayList<>();

    // 求解C(n,k)，当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((LinkedList<Integer>) c.clone());
            return;
        }

        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || k > n) return res;

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    public static void main(String[] args) {

        int n = 4, k = 2;
        List<List<Integer>> res = (new Solution()).combine(n, k);
        System.out.println(res);
    }
}
