package _0416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

/**
 * Date: 2020/9/1 9:26
 * Content: 0-1背包问题：
 */
class Solution3 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int s = sum / 2;
        boolean[] f = new boolean[s + 1];
        f[0] = true;
        for (int x : nums)
            for (int j = sum / 2; j >= x; j--)
                f[j] = f[j] || f[j - x];
        return f[s];
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println((new Solution3()).canPartition(nums));  // true
    }
}
