package _0047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: 2020/9/18 9:51
 * Content:
 */
public class Solution2 {
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    // p中保存了一个有index个元素的排列
    // 向这个排列的末尾添加第 index+1 个元素，获得一个有 index+1 个元素的排列
    private void generatePermutation(int[] nums, LinkedList<Integer> p) {
        if (p.size() == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])  // 剪枝，去重
                    continue;

                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums,  p);
                used[i] = false;
                p.removeLast();
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, p);

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {3, 3, 0, 3};
        System.out.println((new Solution2()).permuteUnique(nums));
    }
}
