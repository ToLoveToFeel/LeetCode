package _0000_study.classicalproblems.majorityelement;

import java.util.Arrays;

/**
 * Date: 2020/8/24 15:41
 * Content: 排序
 * 时间复杂度：O(n^logn)
 * 空间复杂度：O(logn)
 */
public class Solution3 {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println((new Solution3()).majorityElement(nums));
    }
}
