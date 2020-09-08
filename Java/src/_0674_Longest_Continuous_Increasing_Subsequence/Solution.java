package _0674_Longest_Continuous_Increasing_Subsequence;

/**
 * Date: 2020/9/8 8:42
 * Content:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * Leetcode 674 --> Leetcode 300    Leetcode 128
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int index = 0;

        while (index < nums.length) {
            int length = 1;
            int curIndex = index;
            while (curIndex + 1 < nums.length && nums[curIndex] < nums[curIndex + 1]) {
                curIndex++;
                length++;
            }
            res = Math.max(res, length);
            index = curIndex + 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println((new Solution()).findLengthOfLCIS(nums));
    }
}
