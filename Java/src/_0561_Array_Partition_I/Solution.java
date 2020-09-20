package _0561_Array_Partition_I;

import java.util.Arrays;

/**
 * Date: 2020/9/20 20:24
 * Content:
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println((new Solution()).arrayPairSum(nums));
    }
}
