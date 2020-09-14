package _0121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.Stack;

/**
 * Date: 2020/9/14 15:59
 * Content:
 * 单调栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int[] prices2 = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++)
            prices2[i] = prices[i];
        prices2[prices.length] = -1;  // 哨兵，保证所有元素都出栈

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices2.length; i++) {
            while (!stack.isEmpty() && prices2[i] <= stack.peek()) {  // 保证后加入的数据递增
                res = Math.max(res, stack.peek() - stack.firstElement());
                stack.pop();
            }
            stack.push(prices2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        System.out.println((new Solution3()).maxProfit(prices));
    }
}
