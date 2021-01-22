package _0152_Maximum_Product_Subarray;

/**
 * Date: 2020/10/4 10:01
 * Content:
 * 动态规划
 * 状态：
 * dpMax[i] 代表 nums[0...i]且必须包含nums[i]的乘积最大子数组
 * dpMin[i] 代表 nums[0...i]且必须包含nums[i]的乘积最小子数组
 * <p>
 * 状态转移：
 * dpMax[i] = Math.max(dpMax[i-1]*nums[i], Math.max(dpMin[i-1]*nums[i], nums[i]))
 * dpMin[i] = Math.min(dpMax[i-1]*nums[i], Math.min(dpMin[i-1]*nums[i], nums[i]))
 * <p>
 * Solution的空间优化
 */
public class Solution2 {

    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;

        int dpMax = nums[0];
        int dpMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = dpMax;
            int min = dpMin;
            dpMax = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            dpMin = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            res = Math.max(res, dpMax);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};  // 6
//        int[] nums = {-2, 0, -1};  // 0
//        int[] nums = {-1, 2, 3, -2, 4};  // 48
//        int[] nums = {-1, -5, -2, 2, 3, -2, 4};  // 480
//        int[] nums = {-1, -5, -2, 2, 3};  // 60
//        int[] nums = {-1, 2, 3};  // 6
//        int[] nums = {7, -2, -4};  // 56
        System.out.println((new Solution2()).maxProduct(nums));
    }
}
