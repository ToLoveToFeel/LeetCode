package _0486_Predict_the_Winner;


/**
 * Date: 2020/9/7 14:57
 * Content:
 * 动态规划
 */
public class Solution3 {
    // 状态：dp[i][j]：作为先手，在区间nums[i...j]可以获得的最大净分数(先手与后手的分数最大差值)
    // 状态转移：dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
    //              dp[i][j-1]      dp[i][j]
    //                              dp[i+1][j]
    // 因此需要从右下角向左上角计算，每一行从左向右计算
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = nums[i];

        for (int i = n - 2; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);

        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println((new Solution3()).PredictTheWinner(nums) ? "win" : "fail");
    }
}
