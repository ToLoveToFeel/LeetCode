package _0416_Partition_Equal_Subset_Sum;

/**
 * Date: 2020/9/1 9:26
 * Content:
 * 0-1背包问题：
 * Timeout
 */
class Solution {
    // 使用nums[0...index]，是否可以填满一个容量为sum的背包
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum ==0)
            return true;
        if (sum < 0  || index<0)
            return false;

        return tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index]);
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

        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println((new Solution()).canPartition(nums));
    }
}
