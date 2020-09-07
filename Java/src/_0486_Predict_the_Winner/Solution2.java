package _0486_Predict_the_Winner;

import java.util.Arrays;

/**
 * Date: 2020/9/7 14:57
 * Content:
 * 使用记忆化搜索优化改代码
 */
public class Solution2 {
    // memo[i][j]：作为先手，在区间nums[i...j]可以获得的最大净分数(先手与后手的分数最大差值)
    private int[][] memo;

    // 作为先手，在区间nums[i...j]可以获得的最大净分数(先手与后手的分数最大差值)
    private int dfs(int[] nums, int i, int j) {
        if (i > j)
            return 0;

        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];

        int chooseLeft = nums[i] - dfs(nums, i + 1, j);
        int chooseRight = nums[j] - dfs(nums, i, j - 1);
        memo[i][j] = Math.max(chooseLeft, chooseRight);
        return memo[i][j];
    }

    public boolean PredictTheWinner(int[] nums) {
        memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], Integer.MAX_VALUE);

        return dfs(nums, 0, nums.length - 1) >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println((new Solution2()).PredictTheWinner(nums) ? "win" : "fail");
    }
}
