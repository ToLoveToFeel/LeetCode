package _0123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * Date: 2020/9/27 10:33
 * Content:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
 * 动态规划：
 * 状态：dp[i][k][j] 表示到下标为 i 的这一天，完成 kt 次交易，持股状态为 j 时，我们手上拥有的最大现金数(j 0：持有现金, 1：持有股票)
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
 * <p>
 * 执行用时：5 ms, 在所有 Java 提交中击败了80.70%的用户
 * 内存消耗：54.6 MB, 在所有 Java 提交中击败了43.05%的用户
 * <p>
 * Solution2 的空间优化
 */
public class Solution3 {
    public static final int CASH = 0;  // 持有现金
    public static final int STOCK = 1;  // 持有股票

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        int k = 2;  // 代表交易两次
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
        //返回最大值, 只需要考虑持有现金的情况：交易0次，交易1次，交易2次 得到的最大现金数
        int res = 0;
        for (int kt = 0; kt <= k; kt++) {
            res = Math.max(res, dp[kt][CASH]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};  // 6
        System.out.println((new Solution3()).maxProfit(prices));
    }
}
