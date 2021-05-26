package _0664_Strange_Printer;

/**
 * Date: 2021/5/24 11:27
 * 执行用时：35 ms, 在所有 Java 提交中击败了34.21%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了30.45%的用户
 */
public class Solution {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n + 1][n];
        for (int len = 1; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j] = f[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++)
                    if (s.charAt(i) == s.charAt(k))
                        f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
            }
        return f[0][n - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).strangePrinter("aaabbb"));  // 2
    }
}
