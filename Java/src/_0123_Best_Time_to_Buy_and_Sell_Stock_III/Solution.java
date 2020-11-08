package _0123_Best_Time_to_Buy_and_Sell_Stock_III;

/**
 * Date: 2020/9/27 10:33
 * Content:
 * 将数组分为左右两部分，计算左右两部分的最大利润，计算方式和 Leetcode 121 一致
 *
 * 执行用时：9 ms, 在所有 Java 提交中击败了49%的用户
 * 内存消耗：52.1 MB, 在所有 Java 提交中击败了58%的用户
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        // leftDp[i]: 0-i 天的最大利润
        int[] leftDp = new int[n];
        int curMinPrice = prices[0];
        leftDp[0] = 0;
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], prices[i] - curMinPrice);
            curMinPrice = Math.min(curMinPrice, prices[i]);
        }

        // rightDp[i]: i - n-1 天的最大利润
        int[] rightDp = new int[n];
        int curMaxPrice = prices[n-1];
        rightDp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], curMaxPrice - prices[i]);
            curMaxPrice = Math.max(curMaxPrice, prices[i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++)  // 考虑做两次交易
            res = Math.max(res, leftDp[i] + rightDp[i + 1]);
        res = Math.max(res, leftDp[n-1]);  // 考虑只做一次交易，没有这句话，对于输入{3, 4}无法得到正确结果
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};  // 6
        System.out.println((new Solution()).maxProfit(prices));
    }
}
