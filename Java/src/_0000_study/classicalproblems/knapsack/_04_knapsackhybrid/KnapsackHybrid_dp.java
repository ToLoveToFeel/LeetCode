package _0000_study.classicalproblems.knapsack._04_knapsackhybrid;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/12/6 20:58
 * Content:
 */
public class KnapsackHybrid_dp {

    // 拆分后的物品重量和价值
    private static class Good {
        private int kind;  // 物品的类别
        private int weight;  // 物品的重量
        private int value;  // 物品的价值

        public Good(int kind, int weight, int value) {
            this.kind = kind;
            this.weight = weight;
            this.value = value;
        }
    }

    public int knapsackHybrid(int[] weights, int[] values, int[] nums, int C) {

        int n = weights.length;
        List<Good> goods = new ArrayList<>();

        // 数据预处理，将多重背包中的物品进行拆分
        for (int i = 0; i < n; i++) {

            int weight = weights[i];
            int value = values[i];
            int num = nums[i];

            if (num < 0) {  // 说明是 01背包
                goods.add(new Good(-1, weight, value));
            } else if (num == 0) {  // 说明是 完全背包
                goods.add(new Good(0, weight, value));
            } else {  // 说明是 多重背包
                for (int k = 1; k <= num; k *= 2) {  // k为拆分出来物品的个数
                    num -= k;
                    goods.add(new Good(-1, weight * k, value * k));
                }
                if (num > 0) {
                    goods.add(new Good(-1, weight * num, value * num));
                }
            }
        }

        // 判断物品的类别，按照物品的类别进行状态转移即可
        int[] dp = new int[C + 1];

        for (Good good : goods) {
            if (good.kind == -1) {  // 说明是 01背包
                for (int j = C; j >= good.weight; j--) {  // 递减遍历
                    dp[j] = Math.max(dp[j], dp[j - good.weight] + good.value);
                }
            } else {  // 说明是 完全背包
                for (int j = good.weight; j <= C; j++) {  // 递增遍历
                    dp[j] = Math.max(dp[j], dp[j - good.weight] + good.value);
                }
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 4};  // 每件物品的重量
        int[] values = {2, 4, 4, 5};  // 每件物品的价值
        int[] nums = {-1, 1, 0, 2};  // 每类物品的数量
        int weightCapacity = 5;  // 最大能承载的重量
        System.out.println(
                (new KnapsackHybrid_dp()).knapsackHybrid(
                        weights,
                        values,
                        nums,
                        weightCapacity
                )
        );
    }
}
