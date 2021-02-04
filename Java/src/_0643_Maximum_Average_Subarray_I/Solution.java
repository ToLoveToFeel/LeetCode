package _0643_Maximum_Average_Subarray_I;

/**
 * Date: 2020/12/14 9:16
 * Content: 滑动窗口
 * 执行用时：5 ms, 在所有 Java 提交中击败了44.97%的用户
 * 内存消耗：43.1 MB, 在所有 Java 提交中击败了15.26%的用户
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {

        double res = Integer.MIN_VALUE;
        for (int i = 0, j = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            if (i - j + 1 > k) s -= nums[j++];
            if (i >= k - 1) res = Math.max(res, s / (double) k);  // 滑动窗口的大小等于 k
        }

        return res;
    }

    public static void main(String[] args) {

        // 12.75
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println((new Solution()).findMaxAverage(nums, k));
    }
}
