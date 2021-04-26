package _0091_Decode_Ways;

/**
 * Date: 2021/1/25 13:31
 * Content: 动态规划
 * 执行用时：2 ms, 在所有 Java 提交中击败了30.32%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了67.46%的用户
 */
public class Solution {

    public int numDecodings(String s) {

        int n = s.length();
        char[] cs = (' ' + s).toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (cs[i] >= '1' && cs[i] <= '9') f[i] += f[i - 1];
            if (i > 1) {
                int t = (cs[i - 1] - '0') * 10 + cs[i] - '0';
                if (t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public static void main(String[] args) {

        System.out.println((new Solution()).numDecodings("226"));  // 3
    }
}
