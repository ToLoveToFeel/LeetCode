package _0239_Sliding_Window_Maximum;

import _0000_study._common.Output;

/**
 * Date: 2020/11/9 15:27
 * Content: 暴力解法
 * 一共会有 nums.length - k + 1 个结果
 * <p>
 * 超出时间限制
 */
public class Solution {

    // 在 nums[l...r]中寻找最大值
    private int maxSlidingWindow(int[] nums, int l, int r) {

        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length - k + 1;
        if (length <= 0) throw new IllegalArgumentException("Input error!");

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = maxSlidingWindow(nums, i, i + k - 1);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = (new Solution()).maxSlidingWindow(nums, k);

        Output.OutputBasicArray1D(res);
    }
}
