package _0000_study.classicalproblems.knapsack.knapsack01;

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
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c < 0)  // 如果不存在物品 或者 背包容量为0
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, bestValue(w, v, index - 1, c - w[index]) + v[index]);
        memo[index][c] = res;
        return res;
    }

    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;  // 物品的个数
        memo = new int[n][C + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValue(w, v, n - 1, C);
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new Knapsack01_memo()).knapsack01(w, v, C));
    }
}
