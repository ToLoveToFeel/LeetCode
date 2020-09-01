package _0000_classicalProblems.knapsack.Knapsack01;

/**
 * Date: 2020/9/1 17:32
 * Content:
 * 时间复杂度：O(n*C)
 * 空间复杂度：O(C)
 */
public class Knapsack01_dp3 {
    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;  // 物品的个数
        int[] dp = new int[C + 1];

        for (int j = 0; j <= C; j++)
            dp[j] = (j >= w[0] ? v[0] : 0);
        for (int i = 1; i < n; i++)
            for (int j = C; j >= w[i]; j--) {
                dp[j] = dp[j-1];
                if (j >= w[i])
                    dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new Knapsack01_dp3()).knapsack01(w, v, C));
    }
}
