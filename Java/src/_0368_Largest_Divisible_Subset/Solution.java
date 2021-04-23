package _0368_Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/4/23 9:45
 * 执行用时：24 ms, 在所有 Java 提交中击败了49.72%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了70.17%的用户
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int k = 0;  // 记录f最大时的下标，即f[k]最大
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0)
                    f[i] = Math.max(f[i], f[j] + 1);
            if (f[k] < f[i]) k = i;
        }

        // 反向递推出答案
        List<Integer> res = new ArrayList<>();
        res.add(nums[k]);
        while (f[k] > 1) {
            for (int i = 0; i < k; i++)
                if (nums[k] % nums[i] == 0 && f[k] == f[i] + 1) {
                    res.add(nums[i]);
                    k = i;
                    break;
                }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).largestDivisibleSubset(new int[]{1, 2, 3}));
    }
}
