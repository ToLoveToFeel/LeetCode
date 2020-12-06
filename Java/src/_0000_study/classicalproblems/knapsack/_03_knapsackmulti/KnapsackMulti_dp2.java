package _0000_study.classicalproblems.knapsack._03_knapsackmulti;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/9/8 22:45
 * Content: 时间复杂度：O(n * C * t)  其中 t = max(nums)
 * 和 KnapsackMulti_dp 相比，取消了开始的初始化，则 i 要改为从 0 开始遍历
 */
public class KnapsackMulti_dp2 {

    // dp[n][C]：考虑将前n个物品(物品编号从0开始)放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] weights, int[] values, int[] nums, int C) {

        int n = weights.length;  // 类别的个数
        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= weights[i]; j--) {  // 因为要用到上一行的信息，所以j要从大到小变化
                for (int k = 1; k <= nums[i] && k * weights[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weights[i]] + k * values[i]);
                }
            }
//            System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList()));
        }
        return dp[C];
    }

    public static void main(String[] args) {

        int[] weights = {1, 3, 2};  // 每件物品的重量
        int[] values = {4, 7, 6};  // 每件物品的价值
        int[] nums = {2, 2, 3};  // 每类物品的数量
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println(
                (new KnapsackMulti_dp2()).knapsackMulti(
                        weights,
                        values,
                        nums,
                        weightCapacity
                )
        );
    }
}
