package _0039_Combination_Sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/9 7:57
 * Content:
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
            c.add(candidates[i]);
            generateCombination(candidates, target - candidates[i], i, c);  // 从i开始，可以防止出现重复组合
            c.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        LinkedList<Integer> c = new LinkedList<>();

        generateCombination(candidates, target, 0, c);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> res = (new Solution()).combinationSum(candidates, target);
        System.out.println(res);
    }
}
