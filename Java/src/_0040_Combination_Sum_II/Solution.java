package _0040_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/10 10:18
 * Content:
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class Solution {
    private ArrayList<List<Integer>> res;

    // 求解该问题，当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombination(int[] candidates, int target, int start, LinkedList<Integer> c) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 因为之前已经排序，这样可以使的同一层不出现相同元素，不同层之间可以出现相同元素
            /*
                              1
                             / \
                            2   2  这种情况不会发生 但是却允许了不同层级之间的重复,如下图：
                           /     \      因为在 i > start 的情况下，不允许两个2出现在同一层（candidates[i] == candidates[i - 1]）
                          5       5

                              1
                             /
                            2      这种情况确是允许的
                           /
                          2
             */
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            c.add(candidates[i]);
            // 不从 i 开始(Leetcode 0039是从 i开始的)，目的是不允许同一个索引对应的数字出现多次
            generateCombination(candidates, target - candidates[i], i + 1, c);
            c.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 不同于 Leetcode 39，该题需要先对数据排序
        // 类似于 Leetcode 47，全排列II，本题和 Leetcode 47 都需要先进行排序，目的都是为了方便剪枝
        Arrays.sort(candidates);

        res = new ArrayList<>();
        LinkedList<Integer> c = new LinkedList<>();

        generateCombination(candidates, target, 0, c);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = (new Solution()).combinationSum2(candidates, target);
        System.out.println(res);
    }
}
