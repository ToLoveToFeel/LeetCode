package _0000_study.classicalproblems.knapsack._01_knapsack01;

import java.util.Arrays;

/**
 * Date: 2020/9/1 17:11
 * Content:
 * 时间复杂度：O(n*C)
 * 空间复杂度：O(n*C)
 */
public class Knapsack01_memo {

    int[][] memo;

    // 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
    private int bestValue(int[] weights, int[] values, int index, int c) {

        if (index < 0 || c < 0)  // 如果不存在物品 或者 背包容量为0
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(weights, values, index - 1, c);
        if (c >= weights[index])
            res = Math.max(res, bestValue(weights, values, index - 1, c - weights[index]) + values[index]);
        memo[index][c] = res;

        return res;
    }

    public int knapsack01(int[] weights, int[] values, int C) {

        int n = weights.length;  // 物品的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return bestValue(weights, values, n - 1, C);
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};  // 每件物品的重量
        int[] values = {6, 10, 12};  // 每件物品的价值
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println("物品的总价值最大为：" +
                (new Knapsack01_memo()).knapsack01(weights, values, weightCapacity));
    }
}
