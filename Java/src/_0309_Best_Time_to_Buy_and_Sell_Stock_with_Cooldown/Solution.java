package _0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * Date: 2021/1/9 10:54
 * Content:
 * f[i][0]: 手上不持有股票，并且不在冷冻期中的累计最大收益
 * f[i][1]: 手上持有股票的最大收益
 * f[i][2]: 手上不持有股票，并且处于冷冻期中的累计最大收益
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.76%的用户
 * 内存消耗：37.6 MB, 在所有 Java 提交中击败了54.46%的用户
 */
public class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) return 0;
        int[][] f = new int[n][3];
        f[0][1] = -prices[0];
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
            f[i][2] = f[i - 1][1] + prices[i];
        }
        return Math.max(f[n - 1][0], f[n - 1][2]);
    }

    public static void main(String[] args) {

//        int[] prices = {1, 2, 3, 0, 2};  // 3
        int[] prices = {1, 2, 4};  // 3
        System.out.println((new Solution()).maxProfit(prices));

    }
}
