package _0000_study.classicalproblems.lis;

import java.util.Arrays;

/**
 * Date: 2020/9/3 20:26
 * Content:
 * 动态规划
 */
// 时间复杂度：O(n^2)
// 空间复杂度：O(n)
public class Solution3 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        // 状态：dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        // 状态转移： dp[i] = Math.max(dp[i], 1 + dp[j])  其中 0<j<i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, dp[i]);

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {-2, -1};
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution3()).lengthOfLIS(nums));
    }
}
