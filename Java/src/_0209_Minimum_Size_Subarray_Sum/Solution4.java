package _0209_Minimum_Size_Subarray_Sum;

/**
 * 二分搜索
 * 时间复杂度：O(n*logn)
 * 空间复杂度：O(n)
 */
public class Solution4 {

    public int minSubArrayLen(int s, int[] nums) {

        if (s < 0 || null == nums)
            throw new IllegalArgumentException("Illigal Arguments");

        int[] sums = new int[nums.length + 1];  // sums[i]代表nums[0...i)的和
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];  // sums数组是排好序的

        int res = nums.length + 1;
        for (int l = 0; l < nums.length; l++) {
            // sums[r] - sums[l] >= s   [0...r) - [0...l) = [l...r)  区间长度 r - l
            int r = lowerBound(sums, sums[l] + s);
            if (r != sums.length)
                res = Math.min(res, r - l);
        }

        return res == nums.length + 1 ? 0 : res;
    }

    // 在排序的数组 nums 中找到大于或等于 target 的最小数字索引
    // 如果没有这样的索引，则所有在nums中的数字均小于target，则返回nums.length
    private int lowerBound(int[] nums, int target) {
        if (nums == null)
            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");

        int l = 0, r = nums.length;
        while (l != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 3, 1, 2, 4, 3};
//        int[] numbers = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int s = 7;

        System.out.println((new Solution4()).minSubArrayLen(s, numbers));
    }

}
