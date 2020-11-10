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
 * 关于k是否需要逆序遍历的问题：
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/zhuang-tai-ya-suo-shi-guan-yu-kshi-fou-dao-xu-yao-/
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
            dp[kt][STOCK] = -prices[0];
            dp[kt][CASH] = 0;
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

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};  // 6
        System.out.println((new Solution3()).maxProfit(prices));
    }
}

/*
三维数组状态转移：(注意变换的位置，用 ** ** 标记的位置)
    // 处理第 kt + 1 次买入、第 kt + 1 次卖出, kt=0代表第一次买入，卖出
    dp[i][kt][STOCK]    = Math.max(dp[i-1][kt][STOCK],    dp[i-1][kt][CASH] - prices[i]);
    dp[i][kt + 1][CASH] = Math.max(dp[i-1][kt + 1][CASH], **dp[i-1][kt][STOCK]** + prices[i]);
                                        |
                                        |  状态压缩(产生第一个问题的位置)
                                        |  压缩后 dp[kt][STOCK] 其实代表压缩前的 dp[i][kt][STOCK]，与压缩前不符?
                                       \/
    dp[kt][STOCK]    = Math.max(dp[kt][STOCK],    dp[kt][CASH] - prices[i]);
    dp[kt + 1][CASH] = Math.max(dp[kt + 1][CASH], **dp[kt][STOCK]** + prices[i]);
//                                        |
//                                        |  变换(产生第二个问题的位置)
//                                        |  变换后 dp[kt][STOCK] 其实代表变换前的 dp[i][kt - 1][STOCK]，与变换前不符?
//                                       \/
//    dp[kt][STOCK]    = Math.max(dp[kt][STOCK],    dp[kt][CASH] - prices[i]);
//    dp[kt + 1][CASH] = Math.max(dp[kt + 1][CASH], **dp[kt][STOCK]** + prices[i]);


    根据上面描述，有两个问题需要解决：(看错了，不存在第二个问题，为了后面方便知道自己为什么看错了，没有将这些内容删掉)
        (1) 为什么三维数组可以压缩为二维数组？
//        (2) 为什么状态转移方程中可以将 kt - 1 变为 kt？

    (1)对于第一个问题，答案是可以这样变换的，这样做是等价的，证明如下：
        参考网址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/zhuang-tai-ya-suo-shi-guan-yu-kshi-fou-dao-xu-yao-/
            该网址 将 1 理解成CASH，0理解为 STOCK
        原始状态转移方程：
            dp[i][kt][STOCK]    = Math.max(dp[i-1][kt][STOCK],    dp[i-1][kt][CASH] - prices[i]);           (1-1)
            dp[i][kt + 1][CASH] = Math.max(dp[i-1][kt + 1][CASH], **dp[i-1][kt][STOCK]** + prices[i]);      (1-2)
        原始状态转移方程：
            dp[i][kt][STOCK]    = Math.max(dp[i-1][kt][STOCK],    dp[i-1][kt][CASH] - prices[i]);           (1-3)
            dp[i][kt + 1][CASH] = Math.max(dp[i-1][kt + 1][CASH], **dp[i][kt][STOCK]** + prices[i]);        (1-4)
        只需要证明 (1-2) 和 (1-4)等价即可，进一步，证明如下等式即可
        max(dp[i-1][kt + 1][CASH], **dp[i-1][kt][STOCK]** + prices[i]) == max(dp[i-1][kt][CASH], **dp[i][kt - 1][STOCK]** + prices[i])
        左边  = max(dp[i-1][kt+1][CASH], **dp[i][kt][STOCK]** + prices[i])
             = max(dp[i-1][kt+1][CASH], max(dp[i-1][kt][STOCK], dp[i-1][kt][CASH]-price[i]) + price[i])
             = max(dp[i-1][kt+1][CASH]，dp[i-1][kt][STOCK] + price[i], dp[i-1][kt][CASH]-price[i] + price[i])
             = max(dp[i-1][kt+1][CASH]，dp[i-1][kt][STOCK] + price[i], dp[i-1][kt][CASH])
             = max(dp[i-1][kt+1][CASH]，dp[i-1][kt][STOCK] + price[i]) （因为dp[i-1][kt][CASH] <= dp[i-1][kt+1][CASH]恒成立）
             =右边
 */
