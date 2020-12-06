package _0000_study.classicalproblems.knapsack._01_knapsack01;

/**
 * Date: 2020/9/1 17:26
 * Content:
 * 时间复杂度：O(n*C)
 * 空间复杂度：O(2*C) = O(C)
 */
public class Knapsack01_dp2 {

    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    public int knapsack01(int[] weights, int[] values, int C) {

        int n = weights.length;  // 物品的个数
        int[][] dp = new int[2][C + 1];

        for (int j = 0; j <= C; j++)
            dp[0][j] = (j >= weights[0] ? values[0] : 0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= weights[i])
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - weights[i]] + values[i]);
            }
        }

        return dp[(n - 1) % 2][C];
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3};  // 每件物品的重量
        int[] values = {6, 10, 12};  // 每件物品的价值
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println("物品的总价值最大为：" +
                (new Knapsack01_dp2()).knapsack01(weights, values, weightCapacity));
    }
}
