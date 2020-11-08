package _0122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * Date: 2020/9/15 8:34
 * Content:
 * 动态规划:
 * 状态：dp[i][j] 表示到下标为 i 的这一天，持股状态为 j 时，我们手上拥有的最大现金数(j 0：持有现金, 1：持有股票)
 * 状态转移：
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
 *  第 i 天持有现金的最大数目 = max(i-1天没有持有股票时的现金数， i-1天持有股票时的现金数+在第i天卖出股票所获得的现金数)
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  // 第 i 天持有股票获得的最大利润
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {
    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[prices.length][2];

        dp[0][CASH] = 0;
        dp[0][STOCK] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 这两行调换顺序也是可以的
            dp[i][CASH] = Math.max(dp[i - 1][CASH], dp[i - 1][STOCK] + prices[i]);  // 第 i 天持有现金的最大数目
            dp[i][STOCK] = Math.max(dp[i - 1][STOCK], dp[i - 1][CASH] - prices[i]);  // 第 i 天持有股票获得的最大利润
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};  // 7
//        int[] prices = {1, 2, 3, 4, 5};  // 4
//        int[] prices = {7, 6, 4, 3, 1};  // 0
//        int[] prices = {3, 3, 3};  // 0
        System.out.println((new Solution2()).maxProfit(prices));
    }
}
