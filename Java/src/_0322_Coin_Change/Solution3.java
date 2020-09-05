package _0322_Coin_Change;

import java.util.Arrays;

/**
 * Date: 2020/9/5 15:06
 * Content:
 * 动态规划：0-1背包问题
 * 状态：dp[n]：用coins中的面值装满价值为 n 的总金额所需硬币的最少数目
 * 状态转移：dp[i] = min(dp[i], dp[i-coin] + 1)，其中i>=coin,且coin为coins里的元素
 */
public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;  // 物品的数量，但是每一个物品不限量，可以使用多个
        int C = amount;  // 总价值
        int[] dp = new int[C + 1];
        Arrays.fill(dp, C + 1);

        dp[0] = 0;
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= C; j++)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        return dp[C] == amount + 1 ? -1 : dp[C];
    }

    public static void main(String[] args) {
//        int[] coins = {1};
//        int amount = 0;
        int[] coins = {1, 5, 4};
        int amount = 12;
        System.out.println((new Solution3()).coinChange(coins, amount));
    }
}
