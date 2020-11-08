package _0123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * Date: 2020/9/27 10:33
 * Content:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
 * 动态规划：
 * 状态：dp[i][k][j] 表示到下标为 i 的这一天，完成 k 次交易，持股状态为 j 时，我们手上拥有的最大现金数(j 0：持有现金, 1：持有股票)
 * dp[i][0][CASH]：表示第i天交易了0次时卖出后的累计最大利润
 * dp[i][0][STOCK]：表示第i天交易了0次时买入后的累计最大利润(第一次买入)
 * dp[i][1][CASH]：表示第i天交易了1次时卖出后的累计最大利润(第一次卖出)
 * dp[i][1][STOCK]：表示第i天交易了1次时买入后的累计最大利润(第二次买入)
 * dp[i][2][CASH]：表示第i天交易了2次时卖出后的累计最大利润(第二次卖出)
 * dp[i][2][STOCK]：表示第i天交易了2次时买入后的累计最大利润
 * 状态转移：
 * 第一次买入：从初始状态转换而来，或者第一次买入后保持不动
 * dp[i][0][STOCK] = max(dp[i-1][0][STOCK],dp[i-1][0][CASH]-prices[i])
 * 第一次卖出：从第一次买入转换而来，或者第一次卖出后保持不动
 * dp[i][1][CASH] = max(dp[i-1][1][CASH],dp[i-1][0][STOCK]+prices[i])
 * <p>
 * 第二次买入：从第一次卖出转换而来，或者第二次买入后保持不动
 * dp[i][1][STOCK] = max(dp[i-1][1][STOCK],dp[i-1][1][CASH]-prices[i])
 * 第二次卖出：从第二次买入转换而来，或者第二次卖出后保持不动
 * dp[i][2][CASH] = max(dp[i-1][2][CASH],dp[i-1][1][STOCK]+prices[i])
 *
 * 执行用时：107 ms, 在所有 Java 提交中击败了26.66%的用户
 * 内存消耗：68.3 MB, 在所有 Java 提交中击败了5.01%的用户
 */
public class Solution2 {
    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        // 定义三维数组，第i天、交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][3][2];
        // 初始化第一天，这里的dp[0][2][STOCK]可以不用管，后面也不会用到
        dp[0][0][CASH] = 0;
        dp[0][0][STOCK] = -prices[0];
        dp[0][1][CASH] = 0;
        dp[0][1][STOCK] = -prices[0];
        dp[0][2][CASH] = 0;
        dp[0][2][STOCK] = -prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i][0][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0][CASH] = dp[i - 1][0][CASH];
            // 处理第一次买入、第一次卖出
            dp[i][0][STOCK] = Math.max(dp[i - 1][0][STOCK], dp[i - 1][0][CASH] - prices[i]);
            dp[i][1][CASH] = Math.max(dp[i - 1][1][CASH], dp[i - 1][0][STOCK] + prices[i]);
            // 处理第二次买入、第二次卖出
            dp[i][1][STOCK] = Math.max(dp[i - 1][1][STOCK], dp[i - 1][1][CASH] - prices[i]);
            dp[i][2][CASH] = Math.max(dp[i - 1][2][CASH], dp[i - 1][1][STOCK] + prices[i]);
        }
        //返回最大值, 只需要考虑持有现金的情况：交易0次，交易1次，交易2次 得到的最大现金数
        return Math.max(Math.max(dp[n - 1][0][CASH], dp[n - 1][1][CASH]), dp[n - 1][2][CASH]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};  // 6
        System.out.println((new Solution2()).maxProfit(prices));
    }
}
