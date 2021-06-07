package _0494_Target_Sum;

/**
 * Date: 2021/6/7 9:07
 */
public class Solution {

    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int u) {
        if (u == nums.length) {
            if (target == 0) ans++;
            return;
        }
        dfs(nums, target - nums[u], u + 1);
        dfs(nums, target + nums[u], u + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        System.out.println((new Solution()).findTargetSumWays(nums, 3));  // 5
    }
}
