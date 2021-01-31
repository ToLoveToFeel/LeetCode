package _0053_Maximum_Subarray;

public class Solution2 {

    // 动态规划，节省空间
    //      ----------------------->
    //  -2  1   -3  4   -1  2   1   -5  4
    public int maxSubArray(int[] nums) {

        int f = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            max = Math.max(max, f);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println((new Solution2()).maxSubArray(nums));  // 6
    }
}


