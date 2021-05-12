package _0357_Count_Numbers_with_Unique_Digits;

/**
 * Date: 2020/10/8 9:05
 * Content:
 * 动态规划：dp[i]：数字为 i 位时各个位数不同的数字个数
 * 状态转移：dp[i+1] = dp[i] + 9*9*8*...*(10-i)
 * 初始：
 * dp[1] = 10
 * dp[2] = dp[1] + 9*9
 * dp[3] = do[2] + 9*9*8
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        n = Math.min(n, 10);

        if (n == 0) return 1;

        int res = 10;
        for (int i = 2, t = 9 * 9; i <= n; i++) {
            res += t;
            t *= (10 - i);
        }
        return res;
    }

    public static void main(String[] args) {

        Solution t = new Solution();
        for (int i = 0; i < 12; i++) {
            System.out.println(t.countNumbersWithUniqueDigits(i));
        }
    }
}
