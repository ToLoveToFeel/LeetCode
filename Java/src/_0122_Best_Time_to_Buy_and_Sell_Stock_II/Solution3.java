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
     * Solution2 的空间优化
 */
public class Solution3 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        // cash：持有现金
        // stock：持有股票
        int cash = 0;
        int stock = -prices[0];

        int preCash = cash;
        int preStock = stock;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preStock + prices[i]);
            stock = Math.max(preStock, preCash - prices[i]);

            preCash = cash;
            preStock = stock;
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};  // 7
//        int[] prices = {1, 2, 3, 4, 5};  // 4
//        int[] prices = {7, 6, 4, 3, 1};  // 0
//        int[] prices = {3, 3, 3};  // 0
        System.out.println((new Solution3()).maxProfit(prices));
    }
}

/*
public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len < 2) {
        return 0;
    }

    // cash：持有现金
    // hold：持有股票
    // 状态数组
    // 状态转移：cash → hold → cash → hold → cash → hold → cash
    int[] cash = new int[len];
    int[] hold = new int[len];

    cash[0] = 0;
    hold[0] = -prices[0];

    for (int i = 1; i < len; i++) {
        // 这两行调换顺序也是可以的
        cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
        hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
    }
    return cash[len - 1];
}
 */

/*
public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len < 2) {
        return 0;
    }

    // cash：持有现金
    // hold：持有股票
    // 状态转移：cash → hold → cash → hold → cash → hold → cash

    int cash = 0;
    int hold = -prices[0];

    int preCash = cash;
    int preHold = hold;
    for (int i = 1; i < len; i++) {
        cash = Math.max(preCash, preHold + prices[i]);
        hold = Math.max(preHold, preCash - prices[i]);

        preCash = cash;
        preHold = hold;
    }
    return cash;
}
 */
