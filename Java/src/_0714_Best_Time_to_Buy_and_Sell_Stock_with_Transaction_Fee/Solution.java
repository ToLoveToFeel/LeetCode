package _0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

/**
 * Date: 2020/12/17 9:33
 * Content: 类似于Leetcode 0122 买卖股票的最佳时机II Solution3
 * 执行用时：7 ms, 在所有 Java 提交中击败了47.73%的用户
 * 内存消耗：47.6 MB, 在所有 Java 提交中击败了79.49%的用户
 */
public class Solution {

    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices, int fee) {

        if (prices.length <= 1)
            return 0;

        int[] dp = new int[2];
        dp[STOCK] = -prices[0];
        dp[CASH] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[STOCK] = Math.max(dp[STOCK], dp[CASH] - prices[i]);
            dp[CASH] = Math.max(dp[CASH], dp[STOCK] + prices[i] - fee);
        }

        return dp[CASH];
    }

    public static void main(String[] args) {

        // 8
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println((new Solution()).maxProfit(prices, fee));
    }
}
