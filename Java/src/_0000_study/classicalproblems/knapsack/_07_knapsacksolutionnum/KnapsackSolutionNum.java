package _0000_study.classicalproblems.knapsack._07_knapsacksolutionnum;

import java.util.Arrays;

/**
 * Date: 2020/12/7 21:21
 * Content:
 */
public class KnapsackSolutionNum {

    public static final int MOD = 1000000007;

    public int knapsackSolutionNum(int[] weights, int[] values, int C) {

        int n = weights.length;  // 物品个数
        // 初始化 dp, 保证所有物品都是从容量为0的状态转移过来
        int[] dp = new int[C + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        // 记录：背包容量恰好为 j 时的方案数
        int[] g = new int[C + 1];
        g[0] = 1;  // 背包容量为 0 时的方案数为1：什么都不选

        for (int i = 0; i < n; i++) {

            int weight = weights[i];
            int value = values[i];
            for (int j = C; j >= weight; j--) {

                int t = Math.max(dp[j], dp[j - weight] + value);  // 考虑 0-i个物品，容量为 j 的情况下最大价值

                // 考虑这两种决策是从哪种决策转移过来的
                // 如果 dp[j], dp[j - weight] == value，说明两种决策都符合要求，都要计算
                int s = 0;
                if (t == dp[j]) s += g[j];
                if (t == dp[j - weight] + value) s += g[j - weight];
                if (s >= MOD) s -= MOD;

                dp[j] = t;
                g[j] = s;
            }
//            System.out.println(Arrays.toString(g));
        }

        int max = 0;  // 寻找最大价值数，因为不一定是所有空间用完才能得到最优解，所以要遍历
        for (int i = 0; i <= C; i++) max = Math.max(max, dp[i]);

        int res = 0;
        for (int i = 0; i <= C; i++) {
            if (max == dp[i]) {
                res += g[i];
                if (res >= MOD) res -= MOD;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        // weightCapacity = 4的情况下：三种最优方案：
        // 第一件、第二件物品：重量为 3，价值为 6
        // 第一件、第三件物品：重量为 4，价值为 6
        // 第四件物品：重量为 4，价值为 6
        int[] weights = {1, 2, 3, 4};  // 每件物品的重量
        int[] values = {2, 4, 4, 6};  // 每件物品的价值
        int weightCapacity = 4;  // 最大能承载的重量
        System.out.println(
                (new KnapsackSolutionNum()).knapsackSolutionNum(
                        weights,
                        values,
                        weightCapacity
                )
        );
    }
}
