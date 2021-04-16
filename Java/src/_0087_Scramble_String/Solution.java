package _0087_Scramble_String;

/**
 * Date: 2021/4/16 9:50
 * 动态规划
 * 执行用时：8 ms, 在所有 Java 提交中击败了61.85%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了60.70%的用户
 */
public class Solution {

    public boolean isScramble(String s1, String s2) {

        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        int n = chs1.length;

        // 初始化状态
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                f[i][j][1] = (chs1[i] == chs2[j]);

        // 状态转移
        for (int len = 2; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++)
                for (int j = 0; j + len - 1 < n; j++)
                    for (int k = 1; k < len; k++) {
                        if (f[i][j][k] && f[i + k][j + k][len - k]) {
                            f[i][j][len] = true;
                            break;
                        }
                        if (f[i][j + len - k][k] && f[i + k][j][len - k]) {
                            f[i][j][len] = true;
                            break;
                        }
                    }
        return f[0][0][n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isScramble("great", "rgeat"));  // true
    }
}
