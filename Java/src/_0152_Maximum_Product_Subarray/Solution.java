package _0152_Maximum_Product_Subarray;

/**
 * Date: 2020/10/4 10:01
 * Content:
 * 动态规划
 * 状态：dp[i] 代表 nums[0...i]且必须包含nums[i]的乘积最大子数组
 * 状态转移：
 * dp[i] = nums[i]              if nums[i] >= 0 && dp[i-1] <= 0
 * dp[i] = nums[i]*dp[i-1]      if nums[i] >= 0 && dp[i-1] > 0
 * dp[i] = nums[i]*dp[i-1]      if nums[i] < 0 && dp[i-1] <= 0
 * if nums[i] < 0 && dp[i-1] > 0
 *          dp[i] = Max(nums[i], nums[i] * nums[j...i-1])   j = 0...i-1
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (nums[i] >= 0) {
                if (dp[i - 1] > 0)
                    dp[i] = nums[i] * dp[i - 1];
                else
                    dp[i] = nums[i];
            } else {
                if (dp[i - 1] <= 0)
                    dp[i] = nums[i] * dp[i - 1];
                else {
                    int temp = nums[i];
                    int max = nums[i];
                    for (int j = i - 1; j >= 0; j--) {
                        temp = temp * nums[j];
                        max = Math.max(max, temp);
                    }
                    dp[i] = max;
                }
            }
        }

        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > res)
                res = dp[i];
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};  // 6
//        int[] nums = {-2, 0, -1};  // 0
//        int[] nums = {-1, 2, 3, -2, 4};  // 48
//        int[] nums = {-1, -5, -2, 2, 3, -2, 4};  // 480
//        int[] nums = {-1, -5, -2, 2, 3};  // 60
        int[] nums = {-1, 2, 3};  // 6
        System.out.println((new Solution()).maxProduct(nums));
    }
}
