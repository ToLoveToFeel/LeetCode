package _0121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * Date: 2020/9/14 15:59
 * Content:
 * 动态规划
 * 状态：dp[i]：第i天所能获得的最大利润（从第0天开始）
 * 状态转移：dp[i] = max(dp[i-1] , prices[i] - min(prices[0...i-1]))
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];  // 默认值为0

        int curMinPrice = prices[0];  // curMinPrice 记录当前考察天数之前的股票最低价
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - curMinPrice);
            if (prices[i] < curMinPrice)
                curMinPrice = prices[i];
        }

        return dp[prices.length - 1];
    }

    public static void main(String[] args) {

//        int[] prices = {7, 1, 5, 3, 6, 4};  // 5
        int[] prices = {7, 6, 4, 3, 1};  // 0
        System.out.println((new Solution()).maxProfit(prices));
    }
}
