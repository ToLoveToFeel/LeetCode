package _0053_Maximum_Subarray;

/**
 * 状态：dp[i]：以nums[i]结尾的最大子序和
 * 状态转移：dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
 */

class Solution {

    public int maxSubArray(int[] nums) {
        // 动态规划
        //      ----------------------->
        //  -2  1   -3  4   -1  2   1   -5  4
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
//            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println((new Solution()).maxSubArray(nums));  // 6
    }
}

