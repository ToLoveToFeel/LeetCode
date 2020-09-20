package _0485_Max_Consecutive_Ones;

/**
 * Date: 2020/9/20 21:28
 * Content:
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;
        int begin = 0, end;  // [begin...end)为连续的1
        int maxLength = 0;

        while (begin < nums.length) {
            while (begin < nums.length && nums[begin] == 0)
                begin++;
            end = begin;
            while (end < nums.length && nums[end] == 1)
                end++;
            maxLength = Math.max(maxLength, end - begin);

            begin = end + 1;  // 因为 nums[end] == 0 或者 end 越界
        }

        return maxLength;
    }

    public static void main(String[] args) {
//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {0, 0, 0};
//        int[] nums = {1};
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println((new Solution()).findMaxConsecutiveOnes(nums));
    }
}
