package _0416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * Date: 2020/9/1 9:26
 * Content:
 * 0-1背包问题：
 * 使用动态规划
 */
class Solution3 {
    /*
    典型的背包问题，在n个物品中选出一定物品，填满sum/2的背包
    状态： F(n, C)考虑将n个物品填满容量为C的背包
    状态转移：F(i, c) = F(i-1, c) || F(i-1, c-w(i))
    时间复杂度：O(n * sum/2) = O(n * sum)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if (sum % 2 != 0)
            return false;

        int n = nums.length;
        int C = sum / 2;
        boolean[] dp = new boolean[C + 1];

        for (int i = 0; i <= C; i++)
            dp[i] = (nums[0] == i);
        for (int i = 1; i < n; i++)
            for (int j = C; j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j - nums[i]];

        return dp[C];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println((new Solution3()).canPartition(nums));
    }
}
