package _0416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * Date: 2020/9/1 9:26
 * Content:
 * 0-1背包问题：
 * 使用记忆化搜索优化代码
 */
class Solution2 {

    // memo[i][c] 表示使用索引[0...i]的这些元素，是否可以完全填充一个容量为c的背包
    // -1 表示未计算；0 表示不可以填充；1 表示可以填充
    int[][] memo;

    // 使用nums[0...index]，是否可以填满一个容量为sum的背包
    private boolean tryPartition(int[] nums, int index, int sum) {

        if (sum == 0)
            return true;
        if (sum < 0 || index < 0)
            return false;

        if (memo[index][sum] != -1)
            return memo[index][sum] == 1;

        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

    /*
    典型的背包问题，在n个物品中选出一定物品，填满sum/2的背包
    状态： F(n, C)考虑将n个物品填满容量为C的背包
    状态转移：F(i, c) = F(i-1, c) || F(i-1, c-w(i))
    时间复杂度：O(n * sum/2) = O(n * sum)
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if (sum % 2 != 0)
            return false;
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println((new Solution2()).canPartition(nums));
    }
}
