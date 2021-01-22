package _0164_Maximum_Gap;

import java.util.Arrays;

/**
 * Date: 2020/11/26 9:34
 * Content: 排序
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.72%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了74.72%的用户
 */
public class Solution {

    public int maximumGap(int[] nums) {

        if (nums.length < 2) return 0;

        // 第一步：排序
        Arrays.sort(nums);

        // 第二步：寻找最小间距
        int res = 0;
        for (int i = 1; i < nums.length; i++)
            res = Math.max(res, nums[i] - nums[i - 1]);

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 1};
        System.out.println((new Solution()).maximumGap(nums));
    }

}
