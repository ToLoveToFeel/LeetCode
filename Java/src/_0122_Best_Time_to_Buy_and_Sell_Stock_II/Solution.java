package _0122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * Date: 2020/9/15 8:34
 * Content:
 * 贪心算法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int buyIndex, sellIndex;  // 买卖股票的时机
        int i = 0;
        int res = 0;  // 结果
        while (i + 1 < prices.length) {
            // 如果下一天的价格大于当前天的价格，则买入
            while (i + 1 < prices.length && prices[i + 1] <= prices[i])
                i++;
            buyIndex = i;

            // 找到股票价格下降(严格下降、不严格下降都行)的前一天
            while (i + 1 < prices.length && prices[i + 1] >= prices[i])
                i++;
            sellIndex = i;

            res += (prices[sellIndex] - prices[buyIndex]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};  // 7
//        int[] prices = {1, 2, 3, 4, 5};  // 4
//        int[] prices = {7, 6, 4, 3, 1};  // 0
        int[] prices = {3, 3, 3};  // 0
        System.out.println((new Solution()).maxProfit(prices));
    }
}


/*
下面证明 “贪心算法” 的有效性。

我们借助 “差分” 这个概念，可以证明 “贪心算法” 的有效性。贪心算法就是选择那些所有差分（严格）大于 0 的数，把它们相加即可。

使用反证法：假设 “贪心算法” 得到的解并不是最优解，即我们还能够找到一个可行解比 “贪心算法” 得到的利润还多。差分数组中除了差分为正数的项以外，还有就是差分为 0 的项与差分为负数的项。“贪心算法” 是所有差分为正数的项的和。

1、如果可行解在 “贪心算法” 的基础上，选择了差分为 0 的项，得到的结果与“贪心算法”得到的结果一样，因此加上差分为 0 的项不会比“贪心算法”得到的结果更好；

2、如果可行解在 “贪心算法” 的基础上，选择了差分为负数的项，加上一个负数得到的结果一定比 “贪心算法” 得到的结果要少，加上差分为负数的项，一定比 “贪心算法” 得到的结果更少；

3、如果可行解在 “贪心算法” 的基础上，去掉了任何一个差分为正数的项，同上，得到的结果一定比 “贪心算法” 得到的结果要小，因此，“贪心算法” 的所有组成项不能删去任何一个。

综上，除了 “贪心算法” 以外，找不到一个更优的解法，因此 “贪心算法” 就是最优解。（证完）
 */
