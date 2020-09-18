package _0000_study.classicalproblems.knapsack.knapsackcomplete;

/**
 * Date: 2020/9/5 18:36
 * Content:
 */
public class KnapsackComplete_dp {
    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackComplete(int[] w, int[] v, int C) {
        int n = w.length;  // 类别的个数
        int[] dp = new int[C + 1];

        // 因为不需要上一行的值，因此不需要计算
        dp[0] = 0;
        for (int i = 0; i < n; i++)  // 从第0个物品开始放入，可以重复（物品下标从0开始）
            for (int j = w[i]; j <= C; j++)
                // j 从小向大变化（表格从左向右更新）是因为不需要使用上一行的值
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {5, 11, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new KnapsackComplete_dp()).knapsackComplete(w, v, C));
    }
}
