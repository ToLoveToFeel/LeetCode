package _0153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * Date: 2020/9/24 13:42
 * Content:
 */
public class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < res)
                res = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {1};
        int[] nums = {1, 2};
        System.out.println((new Solution()).findMin(nums));
    }
}
