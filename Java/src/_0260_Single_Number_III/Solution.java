package _0260_Single_Number_III;

import _0000_study._common.Output;

/**
 * Date: 2021/2/1 14:41
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.94%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了45.39%的用户
 */
public class Solution {

    private int get(int[] nums, int k, int t) {

        int res = 0;
        for (int x : nums)
            if ((x >> k & 1) == t)
                res ^= x;
        return res;
    }

    public int[] singleNumber(int[] nums) {

        int ab = 0;
        for (int x : nums) ab ^= x;
        int k = 0;
        while ((ab >> k & 1) == 0) k++;
        return new int[]{get(nums, k, 0), get(nums, k, 1)};
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};
        Output.OutputBasicArray1D((new Solution()).singleNumber(nums));  // [5, 3]
    }
}
