package _0000_study.classicalproblems.knapsack._03_knapsackmulti;

import java.util.Arrays;

/**
 * Date: 2020/9/8 22:25
 * Content:
 */
public class KnapsackMulti_memo {

    private int[][] memo;

    // 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
    private int bestValue(int[] weights, int[] values, int[] nums, int index, int c) {

        if (index < 0 || c < 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];
        int res = bestValue(weights, values, nums, index - 1, c);
        int k = 1;
        while (k <= nums[index] && k * weights[index] <= c) {
            res = Math.max(res, bestValue(weights, values, nums, index - 1, c - k * weights[index]) + k * values[index]);
            k++;
        }
        memo[index][c] = res;

        return res;
    }

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] weights, int[] values, int[] nums, int C) {

        int n = weights.length;  // 物品的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        return bestValue(weights, values, nums, n - 1, C);
    }

    public static void main(String[] args) {

        int[] weights = {1, 3, 2};  // 每件物品的重量
        int[] values = {4, 7, 6};  // 每件物品的价值
        int[] nums = {2, 2, 3};  // 每类物品的数量
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println(
                (new KnapsackMulti_memo()).knapsackMulti(
                        weights,
                        values,
                        nums,
                        weightCapacity
                )
        );
    }
}
