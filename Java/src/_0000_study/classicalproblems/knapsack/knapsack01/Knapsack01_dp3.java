package _0000_study.classicalproblems.knapsack.knapsack01;

/**
 * Date: 2020/9/1 17:32
 * Content:
 * 时间复杂度：O(n*C)
 * 空间复杂度：O(C)
 */
public class Knapsack01_dp3 {
    // dp[n][C]：考虑将前n个物品放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;  // 物品的个数
        int[] dp = new int[C + 1];

        // 因为需要上一行的信息，所以首先要算出上一行的信息
        for (int j = 0; j <= C; j++)
            dp[j] = (j >= w[0] ? v[0] : 0);
        for (int i = 1; i < n; i++)  // 从第1个物品开始，不可以重复（物品下标从0开始）
            for (int j = C; j >= w[i]; j--)
                // j 从大向小变化（表格从右向左更新）是因为需要使用上一行的值
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;
        System.out.println("物品的总价值最大为：" + (new Knapsack01_dp3()).knapsack01(w, v, C));
    }
}
