package _0000_study.classicalproblems.knapsack._05_knapsackhy2d;

/**
 * Date: 2020/12/6 21:25
 * Content:
 */
public class Knapsack2d {

    public int knapsackHybrid(int[] weights, int[] volumes, int[] values, int wC, int vC) {

        int n = weights.length;  // 物品个数

        int[][] dp = new int[wC + 1][vC + 1];
        for (int i = 0; i < n; i++) {

            int weight = weights[i];
            int volume = volumes[i];
            int value = values[i];

            for (int j = wC; j >= weight; j--) {  // 01背包 递减
                for (int k = vC; k >= volume; k--) {  // 01背包 递减
                    dp[j][k] = Math.max(dp[j][k], dp[j - weight][k - volume] + value);
                }
            }
        }

        return dp[wC][vC];
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 4};  // 每件物品的重量
        int[] volumes = {2, 4, 4, 5};  // 每件物品的体积
        int[] values = {3, 4, 5, 6};  // 每类物品的价值
        int weightCapacity = 5;  // 背包最大能承载的重量
        int volumeCapacity = 6;  // 背包最大容积
        System.out.println(
                (new Knapsack2d()).knapsackHybrid(
                        weights,
                        volumes,
                        values,
                        weightCapacity,
                        volumeCapacity
                )
        );
    }
}
