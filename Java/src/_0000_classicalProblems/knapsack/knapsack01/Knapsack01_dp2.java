package _0000_classicalProblems.knapsack.knapsack01;

/**
 * Date: 2020/9/1 17:26
 * Content:
 * 时间复杂度：O(n*C)
 * 空间复杂度：O(2*C) = O(C)
 */
public class Knapsack01_dp2 {
    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;  // 物品的个数
        int[][] dp = new int[2][C + 1];

        for (int j = 0; j <= C; j++)
            dp[0][j] = (j >= w[0] ? v[0] : 0);
        for (int i = 1; i < n; i++)
            for (int j = 0; j <= C; j++) {
                dp[i%2][j] = dp[(i - 1)%2][j];
                if (j >= w[i])
                    dp[i%2][j] = Math.max(dp[i%2][j], dp[(i - 1)%2][j - w[i]] + v[i]);
            }
        return dp[(n - 1)%2][C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new Knapsack01_dp2()).knapsack01(w, v, C));
    }
}
