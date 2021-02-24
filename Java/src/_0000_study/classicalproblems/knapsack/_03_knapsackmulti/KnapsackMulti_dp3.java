package _0000_study.classicalproblems.knapsack._03_knapsackmulti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 2020/12/6 20:00
 * Content: 时间复杂度：O(n * C * log(t))  其中 t = max(nums)
 * 采用二进制优化方法
 * 最下面的说明
 * <p>
 * 进一步优化：KnapsackMulti_dp4
 * https://www.acwing.com/solution/content/6500/
 * https://www.acwing.com/solution/content/26583/
 */
public class KnapsackMulti_dp3 {

    // 拆分后的物品重量和价值
    private static class Good {
        private int weight;
        private int value;

        public Good(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // dp[n][C]：考虑将前n个物品(物品编号从0开始)放进容量为C的背包，使得价值最大
    // dp[C]
    public int knapsackMulti(int[] weights, int[] values, int[] nums, int C) {

        int n = weights.length;  // 类别的个数
        List<Good> goods = new ArrayList<>();

        // 数据预处理，将每个物品进行拆分，拆分方式参考：最下面的说明
        for (int i = 0; i < n; i++) {
            int weight = weights[i];
            int value = values[i];
            int num = nums[i];
            for (int k = 1; k <= num; k *= 2) {  // k为拆分出来物品的个数
                num -= k;
                goods.add(new Good(weight * k, value * k));
            }
            if (num > 0) {
                goods.add(new Good(weight * num, value * num));
            }
        }

        // 此时，上述问题已经转化为 0-1背包问题
        int[] dp = new int[C + 1];

        for (Good good : goods) {
            for (int j = C; j >= good.weight; j--) {  // 因为要用到上一行的信息，所以j要从大到小变化
                dp[j] = Math.max(dp[j], dp[j - good.weight] + good.value);
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
                (new KnapsackMulti_dp3()).knapsackMulti(
                        weights,
                        values,
                        nums,
                        weightCapacity
                )
        );
    }
}

/*
 * 采用二进制优化方法
 * 对于 num, 最少可以用多少个数组合表示出0-num（每个数据只能用一次） ：可以用log(num)上取整个数表示出来
 * 比如 7，可以用1,2,4表示出0-7
 * 0 不选
 * 1 = 1
 * 2 = 2
 * 3 = 1+2
 * 4 = 4
 * 5 = 1+4
 * 6 = 2+4
 * 7 = 1+2+4
 *
 * 比如10，可以用1,2,4,3表示出0-10
 * 0-7省略
 * 8 = 1+4 + 3
 * 9 = 2+4 + 3
 * 10 = 1+2+4 + 3
 */
