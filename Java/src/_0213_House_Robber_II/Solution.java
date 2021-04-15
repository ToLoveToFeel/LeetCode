package _0213_House_Robber_II;

import java.util.Arrays;

/**
 * Date: 2021/4/15 9:08
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.1 MB, 在所有 Java 提交中击败了6.07%的用户
 */
public class Solution {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        int[] f = new int[n + 1], g = new int[n + 1];
        Arrays.fill(f, 0);
        Arrays.fill(g, 0);
        // (1) 考虑不抢劫第一家店，则最后一家店可抢可不抢
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        int res = Math.max(f[n], g[n]);
        // (2) 考虑抢劫第一家店，则最后一家店不可以抢劫
        f[1] = nums[0];
        g[1] = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(res, g[n]);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).rob(new int[]{2, 3, 2}));  // 3
    }
}
