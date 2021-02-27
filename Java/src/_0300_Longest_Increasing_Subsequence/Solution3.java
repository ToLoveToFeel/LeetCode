package _0300_Longest_Increasing_Subsequence;

/**
 * Date: 2020/9/3 20:26
 * Content: 动态规划
 * 状态：f[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
 * 状态转移： dp[i] = Math.max(dp[i], 1 + dp[j])  其中 0<=j<i
 * 执行用时：71 ms, 在所有 Java 提交中击败了70.29%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了21.50%的用户
 */
public class Solution3 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int res = 1;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    f[i] = Math.max(f[i], 1 + f[j]);
            res = Math.max(res, f[i]);
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
