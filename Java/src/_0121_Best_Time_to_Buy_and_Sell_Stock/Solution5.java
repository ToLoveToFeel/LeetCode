package _0121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * Date: 2020/9/14 15:59
 * Content:
 * Solution4 的空间优化
 *
 * Leetcode 0121 的 Solution5 对应
 * Leetcode 0122 的 Solution3
 * Leetcode 0123 的 Solution3
 * Leetcode 0188 的 Solution
 */
public class Solution5 {

    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[] dp = new int[2];

        dp[STOCK] = -prices[0];
        dp[CASH] = 0;

        for (int i = 1; i < n; i++) {
            // 这两行调换顺序也是可以的
            dp[STOCK] = Math.max(dp[STOCK], -prices[i]);  // 第 i 天持有股票获得的最大利润, 这里和后面的股票问题有区别
            dp[CASH] = Math.max(dp[CASH], dp[STOCK] + prices[i]);  // 第 i 天持有现金的最大数目
        }
        return dp[CASH];
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};  // 5
//        int[] prices = {7, 6, 4, 3, 1};  // 0
        System.out.println((new Solution5()).maxProfit(prices));
    }
}
