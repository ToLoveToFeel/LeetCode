package _0209_Minimum_Size_Subarray_Sum;

/**
 * 滑动窗口
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution6 {

    public int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1;  // 滑动窗口：nums[l...r]
        int sum = 0;
        int res = nums.length + 1;

        while (r + 1 < nums.length) {
            while (r + 1 < nums.length && sum < s) sum += nums[++r];
            if (sum >= s) res = Math.min(res, r - l + 1);
            while (l < nums.length && sum >= s) {
                sum -= nums[l++];
                if (sum >= s) res = Math.min(res, r - l + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 3, 1, 2, 4, 3};
//        int[] numbers = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int s = 7;
        System.out.println((new Solution6()).minSubArrayLen(s, numbers));
    }
}
