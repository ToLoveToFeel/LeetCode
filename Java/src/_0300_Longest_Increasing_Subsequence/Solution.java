package _0300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Date: 2020/9/3 20:26
 * Content:
 * 自顶向下，无记忆化搜索，这种方式不行，因为要记录0到任意位置对应数组的最长上升子序列，最后求这里面的最大值
 * error
 */
public class Solution {
    // [0...index] 数组对应最长上升子序列
    private int lengthOfLIS(int[] nums, int index) {
        if (index == 0)
            return 1;

        int max = 1;
        for (int i = 0; i < index; i++){
            int submax = lengthOfLIS(nums, i);
            if (nums[index] > nums[i])
                max = Math.max(max, 1 + submax);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        return lengthOfLIS(nums, nums.length - 1);
    }

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {-2,-1};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println((new Solution()).lengthOfLIS(nums));
    }
}
