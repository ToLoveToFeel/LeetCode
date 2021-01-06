package _0039_Combination_Sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/9 7:57
 * Content:
 * 0039 需要求解出具体结果(顺序不同的序列被视作相同的组合)
 * 0377 需要求解出结果个数(顺序不同的序列被视作不同的组合)
 */
public class Solution {

    private ArrayList<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> c = new LinkedList<>();

    // 求解该问题，当前已经找到的组合存储在c中，需要从start开始搜索新的元素
    private void generateCombination(int[] cs, int target, int start) {

        if (target < 0) return;
        if (target == 0) {
            res.add((List<Integer>) c.clone());
            return;
        }

        // 从start开始，而不是从0开始，可以防止出现重复组合
        for (int i = start; i < cs.length; i++) {
            c.add(cs[i]);
            // 不从 i+1 开始(Leetcode 0040是从 i+1开始的)，目的是允许数字重复
            generateCombination(cs, target - cs[i], i);
            c.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        generateCombination(candidates, target, 0);
        return res;
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> res = (new Solution()).combinationSum(candidates, target);
        System.out.println(res);
    }
}
