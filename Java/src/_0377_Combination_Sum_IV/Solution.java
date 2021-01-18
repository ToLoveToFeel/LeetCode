package _0377_Combination_Sum_IV;

/**
 * Date: 2020/9/9 11:52
 * Content:
 * 类似于：回溯法
 * Timeout
 */
public class Solution {

    private int res;

    private void dfs(int[] nums, int target) {

        if (target < 0) return;
        if (target == 0) res++;
        // 注意与 Leetcode 0039 的区别
        // 从0开始，而不是从start(参照Leetcode 0039)开始，目的是允许出现重复组合
        for (int i = 0; i < nums.length; i++) dfs(nums, target - nums[i]);
    }

    public int combinationSum4(int[] nums, int target) {

        if (nums.length == 0) return 0;
        dfs(nums, target);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println((new Solution()).combinationSum4(nums, target));
    }
}
