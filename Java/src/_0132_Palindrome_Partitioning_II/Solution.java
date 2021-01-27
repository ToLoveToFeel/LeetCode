package _0132_Palindrome_Partitioning_II;

import java.util.Arrays;

/**
 * Date: 2021/1/27 11:15
 * Content:
 * 执行用时：20 ms, 在所有 Java 提交中击败了38.65%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了30.79%的用户
 */
public class Solution {

    public int minCut(String s) {

        int n = s.length();
        s = ' ' + s;  // 避免特殊处理f[0]
        boolean[][] g = new boolean[n + 1][n + 1];
        int[] f = new int[n + 1];  // f[i]：代表s[1...i]最少可以被分为多少个回文串
        Arrays.fill(f, (int) 1e8);
        // 预处理：g[i][j]代表s[i...j]是否为回文串
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= j; i++)
                if (i == j) g[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 > j - 1 || g[i + 1][j - 1]) g[i][j] = true;
                }
        }

        f[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                if (g[j][i])
                    f[i] = Math.min(f[i], f[j - 1] + 1);
        return f[n] - 1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).minCut("aab"));  // 1
    }
}
