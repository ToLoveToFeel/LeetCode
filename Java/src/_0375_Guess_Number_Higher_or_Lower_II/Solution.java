package _0375_Guess_Number_Higher_or_Lower_II;

/**
 * Date: 2020/10/17 11:31
 * Content:
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/dong-tai-gui-hua-c-you-tu-jie-by-zhang-xiao-tong-2/
 * 例子：帮助理解
 * 比如 n = 3
 * <p>
 * 猜1：
 * 答案是1，花费0元
 * 答案是2或者3，这个时候会进入另一个区间[2,3]，花费1+dp[2][3]元
 * 必定赢得游戏，最多花费max(0,1+dp[2][3])元   : max(0, dp[2][3]) + 1
 * <p>
 * 猜2：
 * 答案是1，花费2+dp[1][1]=2+0=2元
 * 答案是2，花费0元
 * 答案是3，花费2+dp[3][3]=2+0=2元
 * 必定赢得游戏，最多花费max(0,2+dp[1][1],2+dp[3][3])元   : max(dp[1][1], dp[3][3]) + 2
 * <p>
 * 猜3：
 * 答案是1或者2,花费3+dp[1][2]元
 * 答案是3，花费0元
 * 必定赢得游戏，最多花费max(0,3+dp[1][2])元   : max(dp[1][2], 0) + 3
 * <p>
 * res = min(max(0, dp[2][3]) + 1, max(dp[1][1], dp[3][3]) + 2, max(dp[1][2], 0) + 3)
 */
public class Solution {
    private int[][] memo;

    // 在[l...r]中无论给的target（l...r中的任意一个值）是多少，所需花费的最少费用
    private int loss(int l, int r) {

        if (l >= r) return 0;
        if (memo[l][r] != 0) return memo[l][r];
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
