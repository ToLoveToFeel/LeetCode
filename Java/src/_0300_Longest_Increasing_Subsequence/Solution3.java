package _0300_Longest_Increasing_Subsequence;

/**
 * Date: 2020/9/3 20:26
 * Content: 动态规划
 * 状态：dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
 * 状态转移： dp[i] = Math.max(dp[i], 1 + dp[j])  其中 0<=j<i
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
public class Solution3 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  // 4
//        int[] nums = {-2, -1};  // 2
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
        System.out.println((new Solution3()).lengthOfLIS(nums));
    }
}
