package _0879_Profitable_Schemes;

/**
 * Date: 2021/6/9 10:51
 * 执行用时：28 ms, 在所有 Java 提交中击败了94.74%的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了64.84%的用户
 */
public class Solution {

    static final int mod = (int) (1e9 + 7);

    public int profitableSchemes(int n, int m, int[] group, int[] profit) {
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int g = group[i], p = profit[i];
            for (int j = n; j >= g; j--)
                for (int k = m; k >= 0; k--)
                    f[j][k] = (f[j][k] + f[j - g][Math.max(0, k - p)]) % mod;
        }
        return f[n][m];
    }

    public static void main(String[] args) {

        int[] group = {2, 2}, profit = {2, 3};
        System.out.println((new Solution()).profitableSchemes(5, 3, group, profit));  // 2
    }
}
