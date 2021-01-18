package _0216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/12 21:58
 * Content: 本题和 Leetcode 0039 类似，唯一的区别是：不允许数字重复，所以从 i+1 开始
 * 即使该题只需要求出一共有多少种方式，也不能用0-1背包的方式解决，因为0-1背包问题对于每个物
 * 品都可选可不选。而本题要求必须选k个!!!
 */
public class Solution {

    List<List<Integer>> res;

    private void generateCombination(int k, int n, int start, LinkedList<Integer> list) {

        if (list.size() > k) return;
        if (list.size() == k && n == 0) {
            res.add((List<Integer>) list.clone());
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            generateCombination(k, n - i, i + 1, list);  // 从 i+1 开始，因为数字不能重复
            list.removeLast();
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {

        res = new ArrayList<>();
        if (n > (19 - k) * k / 2 || k > 9) return res;

        LinkedList<Integer> list = new LinkedList<>();
        generateCombination(k, n, 1, list);
        return res;
    }

    public static void main(String[] args) {

        int k = 3, n = 9;
        System.out.println((new Solution()).combinationSum3(k, n));
    }
}
