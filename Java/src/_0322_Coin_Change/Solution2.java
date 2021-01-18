package _0322_Coin_Change;

import java.util.Arrays;

/**
 * Date: 2020/9/5 15:06
 * Content:
 * 记忆化搜索
 * 时间复杂度：O(coins*amount)
 * Solution的优化
 */
public class Solution2 {

    int[] memo;
    private int max_count;

    // 返回用coins填满amount需要硬币的最少数目，返回-1代表无解
    private int search(int[] coins, int amount) {

        if (amount == 0) return 0;
        if (memo[amount] != -1) return memo[amount];

        int res = max_count;
        for (int coin : coins)
            if (amount >= coin)
                res = Math.min(res, 1 + search(coins, amount - coin));
        memo[amount] = res;
        return res;
    }

    public int coinChange(int[] coins, int amount) {

        max_count = amount + 1;
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = search(coins, amount);
        return res == max_count ? -1 : res;
    }

    public static void main(String[] args) {

//        int[] coins = {1};
//        int amount = 0;
        int[] coins = {1, 5, 4};
        int amount = 12;
        System.out.println((new Solution2()).coinChange(coins, amount));
    }
}
