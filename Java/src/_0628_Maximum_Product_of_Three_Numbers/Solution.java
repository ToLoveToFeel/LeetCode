package _0628_Maximum_Product_of_Three_Numbers;

/**
 * Date: 2020/11/22 9:57
 * Content: 暴力解法
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 * <p>
 * 超出时间限制
 */
public class Solution {

    public int maximumProduct(int[] nums) {

        if (nums.length < 3) throw new IllegalArgumentException("Input error!");

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    res = Math.max(res, nums[i] * nums[j] * nums[k]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println((new Solution()).maximumProduct(nums));
    }
}
