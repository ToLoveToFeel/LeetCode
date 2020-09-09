package _0377_Combination_Sum_IV;

import java.util.Arrays;

/**
 * Date: 2020/9/9 11:52
 * Content:
 * 记忆化搜索
 */
public class Solution2 {
    private int[] memo;

    // 返回和为target的组合的个数
    private int solve(int[] nums, int target) {
        if (target == 0)
            return 1;

        if (memo[target] != -1)
            return memo[target];

        int res = 0;
        for (int i = 0; i < nums.length; i++)
            if (target >= nums[i])
                res += solve(nums, target - nums[i]);
        memo[target] = res;
        return res;
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        solve(nums, target);

        return memo[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println((new Solution2()).combinationSum4(nums, target));
    }
}
