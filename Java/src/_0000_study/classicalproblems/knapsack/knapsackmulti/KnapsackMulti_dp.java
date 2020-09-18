package _0000_study.classicalproblems.knapsack.knapsackmulti;

/**
 * Date: 2020/9/8 22:45
 * Content:
 */
public class KnapsackMulti_dp {
    // dp[n][C]：考虑将前n个物品(物品编号从0开始)放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] w, int[] v, int[] m, int C) {
        int n = w.length;  // 类别的个数
        int[] dp = new int[C + 1];

        for (int j = 0; j <= C; j++)  // 填充第一行
            if (j >= w[0]) {
                int k = 1;
                while (k * w[0] <= j)
                    k++;
                dp[j] = (k - 1) * v[0];
            }

        for (int i = 1; i < n; i++)
            for (int j = C; j >= w[i]; j--) {  // 因为要用到上一行的信息，所以j要从大到小比那里
                int k = 1;
                while (k <= m[i] && k * w[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - k * w[i]] + k * v[i]);
                    k++;
                }
            }
        return dp[C];
    }

    public static void main(String[] args) {
        int[] w = {3, 4, 5};  // 重量
        int[] v = {2, 3, 4};  // 价值
        int[] m = {4, 3, 2};  // 数量
        int C = 15;
        System.out.println((new KnapsackMulti_dp()).knapsackMulti(w, v, m, C));
    }
}
