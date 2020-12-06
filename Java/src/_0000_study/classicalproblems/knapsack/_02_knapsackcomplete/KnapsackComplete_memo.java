package _0000_study.classicalproblems.knapsack._02_knapsackcomplete;

import java.util.Arrays;

/**
 * Date: 2020/9/8 21:55
 * Content:
 */
public class KnapsackComplete_memo {

    int[][] memo;

    // 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
    private int bestValue(int[] weights, int[] values, int index, int c) {

        if (index < 0 || c < 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(weights, values, index - 1, c);
        if (c >= weights[index])
            res = Math.max(res, bestValue(weights, values, index, c - weights[index]) + values[index]);
        memo[index][c] = res;

        return res;
    }

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackComplete(int[] weights, int[] values, int C) {

        int n = weights.length;  // 类别的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        return bestValue(weights, values, n - 1, C);
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};  // 每件物品的重量
        int[] values = {5, 11, 12};  // 每件物品的价值
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println("物品的总价值最大为：" +
                (new KnapsackComplete_memo()).knapsackComplete(weights, values, weightCapacity));
    }
}
