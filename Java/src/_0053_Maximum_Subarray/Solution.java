package _0053_Maximum_Subarray;

class Solution {

    public int maxSubArray(int[] nums) {
        // 动态规划
        //      ----------------------->
        //  -2  1   -3  4   -1  2   1   -5  4
        int[] ends = new int[nums.length];
        ends[0] = nums[0];
        int max = ends[0];
        for (int i = 1; i < nums.length; i++) {
            ends[i] = ends[i - 1] > 0 ? ends[i - 1] + nums[i] : nums[i];
            max = Math.max(max, ends[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println((new Solution()).maxSubArray(nums));
    }
}

