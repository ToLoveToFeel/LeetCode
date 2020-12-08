package _0000_study.classicalproblems.knapsack._08_knapsacksolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/12/8 21:53
 * Content:
 */
public class KnapsackSolution {

    public List<Integer> knapsackSolution(int[] weights, int[] values, int C) {

        // 物品编号：0......n-1
        int n = weights.length;  // 物品个数
        int[][] dp = new int[n + 1][C + 1];  // 这里 n + 1 是为了不需要对编号为n-1的物品单独处理

//        for (int j = 0; j <= C; j++)
//            dp[n - 1][j] = (j >= weights[n - 1] ? values[n - 1] : 0);

        for (int i = n - 1; i >= 0; i--) {  // 物品编号从后向前遍历
            for (int j = 0; j <= C; j++) {  // 因为是二维dp，遍历顺序无所谓
                dp[i][j] = dp[i + 1][j];
                if (j >= weights[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - weights[i]] + values[i]);
            }
        }

        List<Integer> res = new ArrayList<>();
        int c = C;
        for (int i = 0; i <= n - 1; i++) {
            // 满足下述条件说明：编号为 i 的物品加入后价值才能到达最大
            // 因为编号是从小到大的遍历，所以一定要加入
            if (c >= weights[i] && dp[i][c] == dp[i + 1][c - weights[i]] + values[i]) {
                res.add(i);
                c -= weights[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        // weightCapacity = 4的情况下：三种最优方案：
        // 第一件、第二件物品：重量为 3，价值为 6
        // 第一件、第三件物品：重量为 4，价值为 6
        // 第四件物品：重量为 4，价值为 6
        // 输出应该为 [0, 1]
        int[] weights = {1, 2, 3, 4};  // 每件物品的重量
        int[] values = {2, 4, 4, 6};  // 每件物品的价值
        int weightCapacity = 4;  // 最大能承载的重量
        System.out.println((new KnapsackSolution()).knapsackSolution(
                        weights,
                        values,
                        weightCapacity
                )
        );

    }
}
