package _1877_Minimize_Maximum_Pair_Sum_in_Array;

import java.util.Arrays;

/**
 * Date: 2021/7/20 9:40
 * Content:
 * 执行用时：61 ms, 在所有 Java 提交中击败了95.60%的用户
 * 内存消耗：54 MB, 在所有 Java 提交中击败了57.42%的用户
 */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) res = Math.max(res, nums[i++] + nums[j--]);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 5, 2, 3};
        System.out.println((new Solution()).minPairSum(nums));  // 7
    }
}
