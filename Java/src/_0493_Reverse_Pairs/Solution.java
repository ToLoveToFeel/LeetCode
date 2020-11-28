package _0493_Reverse_Pairs;

/**
 * Date: 2020/11/28 14:48
 * Content: 暴力解法
 * 超出时间限制
 */
public class Solution {

    public int reversePairs(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * (long)nums[j])
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 3, 2, 3, 1};
//        int[] nums = {-5, -5};
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println((new Solution()).reversePairs(nums));
    }
}
