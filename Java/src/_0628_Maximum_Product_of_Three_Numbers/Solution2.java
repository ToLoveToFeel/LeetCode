package _0628_Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

/**
 * Date: 2020/11/22 9:57
 * Content: 暴力解法
 * 时间复杂度：O(n^log(n))
 * 空间复杂度：O(1)
 * <p>
 * 思路：排序后，选择 Math.max(最大的三个数乘积，最小的两个数乘积*最大的数)
 * <p>
 * 执行用时：12 ms, 在所有 Java 提交中击败了69.57%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了73.78%的用户
 */
public class Solution2 {

    public int maximumProduct(int[] nums) {

        int n = nums.length;
        if (n < 3)
            throw new IllegalArgumentException("Input error!");

        // 排序
        Arrays.sort(nums);

        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println((new Solution2()).maximumProduct(nums));
    }
}
