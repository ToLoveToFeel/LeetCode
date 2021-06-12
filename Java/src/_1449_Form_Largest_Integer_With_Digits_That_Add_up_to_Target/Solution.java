package _1449_Form_Largest_Integer_With_Digits_That_Add_up_to_Target;

import java.util.Arrays;

/**
 * Date: 2021/6/12 11:06
 * 执行用时：7 ms, 在所有 Java 提交中击败了91.89%的用户
 * 内存消耗：37.6 MB, 在所有 Java 提交中击败了91.89%的用户
 */
public class Solution {

    static final int INF = (int) (2e9);

    public String largestNumber(int[] cost, int target) {
        int n = cost.length;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(f[i], -INF);
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int v = cost[i - 1];
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v) f[i][j] = Math.max(f[i][j], f[i][j - v] + 1);
            }
        }
        if (f[n][target] < -INF / 2) return "0";
        StringBuilder res = new StringBuilder();
        int j = target;
        for (int i = n; i >= 1; i--) {
            int v = cost[i - 1];
            while (j >= v && f[i][j] == f[i][j - v] + 1) {
                res.append(i);
                j -= v;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        System.out.println((new Solution()).largestNumber(cost, 9));  // 7722
    }
}
