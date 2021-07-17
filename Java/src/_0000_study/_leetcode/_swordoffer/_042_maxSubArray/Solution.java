package _0000_study._leetcode._swordoffer._042_maxSubArray;

/**
 * Date: 2021/7/17 14:58
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.83%的用户
 * 内存消耗：45 MB, 在所有 Java 提交中击败了22.48%的用户
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int res = nums[0], f = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(0, f) + nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println((new Solution()).maxSubArray(nums));  // 6
    }
}
