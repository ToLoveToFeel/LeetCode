package _0000_study.classicalproblems.knapsack._02_knapsackcomplete;

/**
 * Date: 2020/9/5 18:36
 * Content:
 */
public class KnapsackComplete_dp {

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackComplete(int[] weights, int[] values, int C) {

        int n = weights.length;  // 类别的个数
        int[] dp = new int[C + 1];

        // 因为不需要上一行的值，因此不需要计算
        dp[0] = 0;
        for (int i = 0; i < n; i++) {  // 从第0个物品开始放入，可以重复（物品下标从0开始）
            for (int j = weights[i]; j <= C; j++) {
                // j 从小向大变化（表格从左向右更新）是因为不需要使用上一行的值
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};  // 每件物品的重量
        int[] values = {5, 11, 12};  // 每件物品的价值
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println("物品的总价值最大为：" +
                (new KnapsackComplete_dp()).knapsackComplete(weights, values, weightCapacity));
    }
}
