package _0010_Regular_Expression_Matching;

/**
 * Date: 2021/5/19 20:00
 * Content:
 * 执行用时：4 ms, 在所有 Java 提交中击败了80.62%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了38.59%的用户
 */
public class Solution {

    public boolean isMatch(String s, String p) {

        int n = s.length(), m = p.length();
        char[] cs = (" " + s).toCharArray(), cp = (" " + p).toCharArray();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (j + 1 <= m && cp[j + 1] == '*') continue;
                if (i != 0 && cp[j] != '*') {
                    f[i][j] = f[i - 1][j - 1] && (cs[i] == cp[j] || cp[j] == '.');
                } else if (cp[j] == '*') {
                    f[i][j] = f[i][j - 2] || (i != 0 && f[i - 1][j] && (cs[i] == cp[j - 1] || cp[j - 1] == '.'));
                }
            }
        return f[n][m];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isMatch("aab", "c*a*b"));  // true
    }
}
