package _0209_Minimum_Size_Subarray_Sum;

/**
 * 前缀和
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */

public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {

        int[] sums = new int[nums.length + 1];  // sums[i]代表nums[0...i)的和
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];

        int length = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                if (sums[r + 1] - sums[l] >= s) {   // [0...r+1) - [0...l) = [l...r]
                    length = Math.min(length, r - l + 1);
                    break;
                }
            }
        }

        return length == nums.length + 1 ? 0 : length;
    }

    public static void main(String[] args) {

//        int[] numbers = {2, 3, 1, 2, 4, 3};
        int[] numbers = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int s = 15;
        System.out.println((new Solution2()).minSubArrayLen(s, numbers));
    }
}
