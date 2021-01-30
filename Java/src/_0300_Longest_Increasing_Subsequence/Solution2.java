package _0300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Date: 2020/9/3 20:26
 * Content:自顶向下，有记忆化搜索
 */
// 状态：dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
// 状态转移： dp[i] = Math.max(dp[i], 1 + dp[j])  其中 0<j<i
public class Solution2 {

    private int[] memo;

    // [0...u] 数组对应最长上升子序列
    private int lengthOfLIS(int[] nums, int u) {

        if (u == 0) return memo[u] = 1;

        if (memo[u] != -1) return memo[u];

        int max = 1;
        for (int i = 0; i < u; i++) {
            memo[i] = lengthOfLIS(nums, i);
            if (nums[i] < nums[u]) max = Math.max(max, 1 + memo[i]);
        }
        memo[u] = max;
        return memo[u];
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        lengthOfLIS(nums, nums.length - 1);

        int res = 1;
        for (int i = 0; i < nums.length; i++) res = Math.max(res, memo[i]);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  // 4
//        int[] nums = {-2, -1};  // 2
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
        System.out.println((new Solution2()).lengthOfLIS(nums));
    }
}
