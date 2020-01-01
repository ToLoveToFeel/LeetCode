package _0209_Minimum_Size_Subarray_Sum;

public class Solution4 {
    // 时间复杂度：O(n*logn)
    // 空间复杂度：O(n)
    public int minSubArrayLen(int s, int[] nums){
        if (s < 0 || null == nums)
            throw new IllegalArgumentException("Illigal Arguments");

        int[] sums = new int[nums.length + 1];  // sums[i]代表nums[0...i)的和
        sums[0] = 0;
        for (int i = 1; i  <= nums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];  // sums数组是排好序的

        int res = nums.length + 1;
        for (int l = 0; l < nums.length; l++){
            int r = lowerBound(sums, sums[l] + s);
            if (r != sums.length)
                res = Math.min(res, r - l);
        }

        return res == nums.length + 1 ? 0 : res;
    }

    // Find the smallest number index which is larger or equal to target
    // in a sorted array nums
    // If there's no such a number, in which all number in nums are smaller than target
    // return nums.length
    private int lowerBound(int[] nums, int target){
        if (null == nums)
            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");
        int l = 0, r = nums.length;
        while (l != r){
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,1,2,4,3};
//        int[] numbers = {5,1,3,5,10,7,4,9,2,8};
        int s = 7;

        System.out.println((new Solution4()).minSubArrayLen(s, numbers));
    }

}
