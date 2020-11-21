package _0209_Minimum_Size_Subarray_Sum;

/**
 * 暴力解法
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 * Time Limit Exceeded
 */

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int length = nums.length + 1;

        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                int sum = 0;
                for (int k = l; k <= r; k++)
                    sum += nums[k];

                if (sum >= s)
                    length = Math.min(length, r - l + 1);
            }
        }

        return length == nums.length + 1 ? 0 : length;
    }

    public static void main(String[] args) {

//        int[] numbers = {2, 3, 1, 2, 4, 3};
        int[] numbers = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int s = 15;

        System.out.println((new Solution()).minSubArrayLen(s, numbers));
    }
}
