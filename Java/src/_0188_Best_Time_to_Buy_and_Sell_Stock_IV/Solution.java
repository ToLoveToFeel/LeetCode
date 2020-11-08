package _0188_Best_Time_to_Buy_and_Sell_Stock_IV;

/**
 * Date: 2020/11/8 11:07
 * Content:
 * 动态规划：请参照Leetcode 0123 的说明
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution {
    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;
        if (k >= n / 2) {  // 当k非常大时转为无限次交易，参照 Leetcode 0122
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

        // 定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k + 1][2];
        // 初始化第一天，这里的dp[2][STOCK]可以不用管，后面也不会用到
        for (int kt = 0; kt <= k; kt++) {
            dp[kt][CASH] = 0;
            dp[kt][STOCK] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int kt = 0; kt < k; kt++) {
                // 处理第 kt + 1 次买入、第 kt + 1 次卖出, kt=0代表第一次买入，卖出
                dp[kt][STOCK] = Math.max(dp[kt][STOCK], dp[kt][CASH] - prices[i]);
                dp[kt + 1][CASH] = Math.max(dp[kt + 1][CASH], dp[kt][STOCK] + prices[i]);
            }
        }
        //返回最大值, 只需要考虑持有现金的情况：交易0次，交易1次，交易2次... 得到的最大现金数
        int res = 0;
        for (int kt = 0; kt <= k; kt++) {
            res = Math.max(res, dp[kt][CASH]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};  // 7
        int k = 2;
        System.out.println((new Solution()).maxProfit(k, prices));
    }
}
