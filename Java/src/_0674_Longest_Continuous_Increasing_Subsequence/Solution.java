package _0674_Longest_Continuous_Increasing_Subsequence;

/**
 * Date: 2020/9/8 8:42
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * Leetcode 674 --> Leetcode 300    Leetcode 128
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.83%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了13.41%的用户
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {

        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            j = i;
            while (j + 1 < nums.length && nums[j] < nums[j + 1]) j++;
            res = Math.max(res, j - i + 1);
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 3, 5, 4, 7};  // 3
        int[] nums = {2, 2, 2, 2, 2};  // 1
        System.out.println((new Solution()).findLengthOfLCIS(nums));
    }
}
