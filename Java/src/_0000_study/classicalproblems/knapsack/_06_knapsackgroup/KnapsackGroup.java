package _0000_study.classicalproblems.knapsack._06_knapsackgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/12/6 21:54
 * Content:
 */
public class KnapsackGroup {

    public int knapsackGroup(List<List<Integer>> weights, List<List<Integer>> values, int C) {

        int n = weights.size();  // 物品组数
        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {  // 枚举所有组
            for (int j = C; j >= 0; j--) {  // 递减

                int s = weights.get(i).size();  // 组内物品种类数目
                for (int k = 0; k < s; k++) {

                    if (j >= weights.get(i).get(k)) {
                        dp[j] = Math.max(dp[j], dp[j - weights.get(i).get(k)] + values.get(i).get(k));
                    }
                }
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {

        // 重量
        List<List<Integer>> weights = new ArrayList<>();
        // 第一组重量
        List<Integer> weightsGroup1 = new ArrayList<>();
        weightsGroup1.add(1);
        weightsGroup1.add(2);
        weights.add(weightsGroup1);
        // 第二组重量
        List<Integer> weightsGroup2 = new ArrayList<>();
        weightsGroup2.add(3);
        weights.add(weightsGroup2);
        // 第三组重量
        List<Integer> weightsGroup3 = new ArrayList<>();
        weightsGroup3.add(4);
        weights.add(weightsGroup3);

        // 价值
        List<List<Integer>> values = new ArrayList<>();
        // 第一组价值
        List<Integer> valuesGroup1 = new ArrayList<>();
        valuesGroup1.add(2);
        valuesGroup1.add(4);
        values.add(valuesGroup1);
        // 第二组价值
        List<Integer> valuesGroup2 = new ArrayList<>();
        valuesGroup2.add(4);
        values.add(valuesGroup2);
        // 第三组价值
        List<Integer> valuesGroup3 = new ArrayList<>();
        valuesGroup3.add(5);
        values.add(valuesGroup3);

        int weightCapacity = 5;  // 背包最大能承载的重量
        System.out.println(
                (new KnapsackGroup()).knapsackGroup(
                        weights,
                        values,
                        weightCapacity
                )
        );
    }
}
