package _0486_Predict_the_Winner;

/**
 * Date: 2020/9/7 14:57
 * Content:
 * 可以通过Leetcode测试，不过效率很低
 */
public class Solution {
    // 作为先手，在区间nums[i...j]可以获得的最大净分数(先手与后手的分数最大差值)
    private int dfs(int[] nums, int i, int j) {
        if (i > j)
            return 0;

        int chooseLeft = nums[i] - dfs(nums, i + 1, j);
        int chooseRight = nums[j] - dfs(nums, i, j - 1);
        return Math.max(chooseLeft, chooseRight);
    }

    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1) >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println((new Solution()).PredictTheWinner(nums) ? "win" : "fail");
    }
}
