package _0000_study._leetcode._swordoffer._051_reversePairs;

/**
 * Date: 2020/11/29 10:25
 * Content: 暴力解法
 * 超出时间限制
 */
public class Solution {

    public int reversePairs(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};  // 5
        System.out.println((new Solution()).reversePairs(nums));
    }
}
