package _0010_Regular_Expression_Matching;

/**
 * Date: 2020/9/25 20:00
 * Content:
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/shi-pin-tu-jie-dong-tai-gui-hua-zheng-ze-biao-da-s/
 * 动态规划：
 * 状态：dp[i][j] 表示 s 的前 i 个字符能否被 p 的前 j 个字符匹配. 例如 dp[1][1] 就代表s.charAt(0)能否与p.charAt(0)匹配
 * 初始状态：
 * dp[0][0] = true (代表空匹配空).
 * dp[i][0] = false (代表某些字符不能匹配空, i >= 1).
 * dp[0][1] = true (如果 p.charAt(0) == '*'), 否则 dp[0][1] = false.
 * dp[0][j] = dp[0][j - 2] (如果 p.charAt(j-1) == '*', j >= 2), 否则 dp[0][j] = false.
 * 状态转移：(从 i=1, j=1 开始填表)
 * 如果 s.charAt(i-1) == p.charAt(j-1), 或者 p.charAt(j-1) == '.':
 * dp[i][j] = dp[i-1][j-1]
 * 如果 p.charAt(j-1) == '*' :
 * 如果 j = 1, 则 dp[i][1] = false
 * 否则 j > 1:
 * 如果 dp[i][j-2] == true, 则 dp[i][j] = true
 * 否则 dp[i][j-2] == false, 如果p中当前考察字符'*'的前一个字符 p.charAt(j-2) == s.charAt(i-1) 或者 p.charAt(j-2) == ‘.', dp[i][j] = dp[i-1][j]
 */
public class Solution {

    public boolean isMatch(String s, String p) {

        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int j = 1; j < dp[0].length; j++) {
            char ch = p.charAt(j - 1);
            if (j > 1) {
                if (ch == '*') {
                    dp[0][j] = dp[0][j - 2];
                } else {
                    dp[0][j] = false;
                }
            } else {
                if (ch == '*') {
                    dp[0][j] = true;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int sIndex = i - 1;
            char ch1 = s.charAt(sIndex);
            for (int j = 1; j < dp[i].length; j++) {
                int pIndex = j - 1;
                char ch2 = p.charAt(pIndex);
                if (ch1 == ch2 || ch2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch2 == '*') {
                    if (j > 1) {
                        if (dp[i][j - 2]) {
                            dp[i][j] = true;  // * 前面的字符出现0次
                        } else {
                            char prev = p.charAt(pIndex - 1);
                            if (prev == ch1 || prev == '.') {
                                dp[i][j] = dp[i - 1][j];  // * 前面的字符出现一次或多次（包含当前这次）
                            }
                        }

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {

        String s = "aab";
        String p = "c*a*b";
        System.out.println((new Solution()).isMatch(s, p));
    }
}
