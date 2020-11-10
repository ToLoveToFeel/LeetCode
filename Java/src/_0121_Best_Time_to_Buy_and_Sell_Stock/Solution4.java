package _0121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.Stack;

/**
 * Date: 2020/9/14 15:59
 * Content:
 * Leetcode 0121 的 Solution4 对应
 * Leetcode 0122 的 Solution2
 * Leetcode 0123 的 Solution2
 */
public class Solution4 {

    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[][] dp = new int[n][2];

        dp[0][STOCK] = -prices[0];
        dp[0][CASH] = 0;

        for (int i = 1; i < n; i++) {
            // 这两行调换顺序也是可以的
            dp[i][STOCK] = Math.max(dp[i - 1][STOCK], -prices[i]);  // 第 i 天持有股票获得的最大利润, 这里和后面的股票问题有区别
            dp[i][CASH] = Math.max(dp[i - 1][CASH], dp[i - 1][STOCK] + prices[i]);  // 第 i 天持有现金的最大数目
        }
        return dp[n - 1][CASH];
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};  // 5
//        int[] prices = {7, 6, 4, 3, 1};  // 0
        System.out.println((new Solution4()).maxProfit(prices));
    }
}
