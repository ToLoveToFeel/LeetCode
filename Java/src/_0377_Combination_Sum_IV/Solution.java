package _0377_Combination_Sum_IV;

/**
 * Date: 2020/9/9 11:52
 * Content:
 * 类似于：回溯法
 * Timeout
 */
public class Solution {
    private int res;

    private void generataCombination(int[] nums, int target) {
        if (target < 0)
            return;
        if (target == 0)
            res++;

        for (int i = 0; i < nums.length; i++)
            generataCombination(nums, target - nums[i]);
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        generataCombination(nums, target);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println((new Solution()).combinationSum4(nums, target));
    }
}
