package _0044_Wildcard_Matching;

/**
 * Date: 2021/5/22 11:39
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        char[] cs = (" " + s).toCharArray(), cp = (' ' + p).toCharArray();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++)  // f[0][j]是有意义的，例如p="***"，因此i从0开始
            for (int j = 1; j <= m; j++)  // f[i][0] (i>0)是没有意义的，因此j从1开始
                if (cp[j] != '*') {
                    f[i][j] = (cs[i] == cp[j] || cp[j] == '?') && i > 0 && f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i][j - 1] || i > 0 && f[i - 1][j];
                }
        return f[n][m];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isMatch("aa", "a"));  // false
    }
}
