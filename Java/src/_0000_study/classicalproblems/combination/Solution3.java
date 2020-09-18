package _0000_study.classicalproblems.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    private ArrayList<List<Integer>> res;

    // 求解 C(n,k) ，当前已经找到的组合存储在 c 中，需要从 [start...n] 选择 k 个元素
    private void dfs(int n, int k, int start, LinkedList<Integer> c) {
        if (k == 0) {
            res.add((List<Integer>) c.clone());
            return;
        }

        // 从 [start...n] 选择 k 个元素，则 [start...n] 至少有 k 个元素
        // 若 n - start + 1 < k, 即 start > n - k + 1 可以直接返回
        if (start > n - k + 1)  // 剪枝
            return;

        // 不选当前考虑的数 start，直接递归到下一层
        dfs(n, k, start + 1, c);

        // 选当前考虑的数 start，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        c.add(start);
        dfs(n, k - 1, start + 1, c);
        c.removeLast();  // 深度优先遍历有回头的过程，因此需要撤销选择
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (!(0 < k && k <= n))
            return res;

        LinkedList<Integer> c = new LinkedList<>();
        dfs(n, k, 1, c);

        return res;
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = (new Solution3()).combine(n, k);
        for (List<Integer> list : res)
            printList(list);
    }
}
