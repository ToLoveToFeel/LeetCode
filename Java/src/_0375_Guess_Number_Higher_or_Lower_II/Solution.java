package _0375_Guess_Number_Higher_or_Lower_II;

/**
 * Date: 2020/10/17 11:31
 * Content:
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/dong-tai-gui-hua-c-you-tu-jie-by-zhang-xiao-tong-2/
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/comments/
 * 记忆化搜索
 */
public class Solution {
    private int[][] memo;

    // 在[l...r]中无论给的target（l...r中的任意一个值）是多少，所需花费的最少费用
    private int loss(int l, int r) {
        if (l >= r)
            return 0;
        if (memo[l][r] != 0)
            return memo[l][r];
        int res = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            // 选择 i 分为两块
            int left = loss(l, i - 1);
            int right = loss(i + 1, r);
            res = Math.min(res, Math.max(left, right) + i);
        }
        memo[l][r] = res;
        return res;
    }

    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        return loss(1, n);
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).getMoneyAmount(10));
        System.out.println((new Solution()).getMoneyAmount(1));
        System.out.println((new Solution()).getMoneyAmount(2));
    }
}
