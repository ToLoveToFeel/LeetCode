package _0000_study.classicalproblems.knapsack.knapsackmulti;

import java.util.Arrays;

/**
 * Date: 2020/9/8 22:25
 * Content:
 */
public class KnapsackMulti_memo {
    private int[][] memo;

    // 用 [0...index] 的物品，填充容积为 c 的背包的最大价值
    private int bestValue(int[] w, int[] v, int[] m, int index, int c) {
        if (index < 0 || c < 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];
        int res = bestValue(w, v, m, index - 1, c);
        int k = 1;
        while (k <= m[index] && k * w[index] <= c) {
            res = Math.max(res, bestValue(w, v, m, index - 1, c - k * w[index]) + k * v[index]);
            k++;
        }
        memo[index][c] = res;
        return res;
    }

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] w, int[] v, int[] m, int C) {
        int n = w.length;  // 物品的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        return bestValue(w, v, m, n - 1, C);
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};  // 重量
        int[] v = {2, 3, 4};  // 价值
        int[] m = {4, 3, 2};  // 数量
        int C = 5;
        System.out.println((new KnapsackMulti_memo()).knapsackMulti(w, v, m, C));
    }
}
