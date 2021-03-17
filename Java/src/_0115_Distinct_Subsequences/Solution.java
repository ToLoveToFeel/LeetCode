package _0115_Distinct_Subsequences;

/**
 * Created by WXX on 2021/3/17 9:09
 * 执行用时：3 ms, 在所有 Java 提交中击败了92.49%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了5.06%的用户
 */
public class Solution {

    public int numDistinct(String s, String t) {

        int n = s.length(), m = t.length();
        char[] s1 = (' ' + s).toCharArray(), t1 = (' ' + t).toCharArray();
        long[][] f = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (s1[i] == t1[j]) f[i][j] += f[i - 1][j - 1];
            }
        return (int) f[n][m];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).numDistinct("rabbbit", "rabbit"));  // 3
        System.out.println((new Solution()).numDistinct("babgbag", "bag"));  // 5
    }
}
