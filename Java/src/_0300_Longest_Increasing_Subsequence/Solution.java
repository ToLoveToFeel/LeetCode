package _0300_Longest_Increasing_Subsequence;

/**
 * Date: 2020/9/3 20:26
 * Content: 自顶向下，无记忆化搜索
 * TLE
 */
public class Solution {

    int ans = 1;

    // nums[0...u] 数组且以nums[i]结尾的最长上升子序列的长度
    private int lengthOfLIS(int[] nums, int u) {

        if (u == 0) return 1;

        int res = 1;
        for (int i = 0; i < u; i++) {
            int t = lengthOfLIS(nums, i);
            if (t > ans) ans = t;  // 以nums[i]结尾的最长上升子序列长度
            if (nums[u] > nums[i]) res = Math.max(res, 1 + t);
        }
        if (res > ans) ans = res;  // 以nums[u]结尾的最长上升子序列长度
        return res;
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;
        lengthOfLIS(nums, nums.length - 1);
        return ans;
    }

    public static void main(String[] args) {

//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};  // 4
//        int[] nums = {-2, -1};  // 2
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};  // 6
        System.out.println((new Solution()).lengthOfLIS(nums));
    }
}
