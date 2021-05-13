package _1269_Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps;

/**
 * Date: 2021/5/13 10:42
 * 执行用时：16 ms, 在所有 Java 提交中击败了61.40%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了60.53%的用户
 */
public class Solution {

    static final int mod = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {

        int n = steps, m = Math.min(arrLen - 1, steps);
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j - 1 >= 0) f[i][j] = (f[i][j] + f[i - 1][j - 1]) % mod;
                if (j + 1 <= m) f[i][j] = (f[i][j] + f[i - 1][j + 1]) % mod;
            }
        return f[n][0];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numWays(3, 2));  // 4
        System.out.println((new Solution()).numWays(2, 4));  // 2
        System.out.println((new Solution()).numWays(4, 2));  // 8
    }
}
