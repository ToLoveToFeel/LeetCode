package _0746_Min_Cost_Climbing_Stairs;

/**
 * Date: 2020/12/21 9:23
 * Content: 动态规划
 * 状态：dp[i] : 爬到第 i 个阶梯，花费的最小体力
 * 状态转移：dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
 * do by myself
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.68%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了98.78%的用户
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return Math.min(dp[n - 2], dp[n - 1]);
    }

    public static void main(String[] args) {

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println((new Solution()).minCostClimbingStairs(cost));
    }
}
