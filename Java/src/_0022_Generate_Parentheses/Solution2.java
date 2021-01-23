package _0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/9/15 10:44
 * Content:
 * 动态规划
 * 状态：dp[i]：使用i对括号能够生成的组合的集合
 * 状态转移：dp[i] = "(" + dp[j] + ")" + dp[(i-1) - j], 其中 j = 0,1,...,n-1
 */
public class Solution2 {

    public List<String> generateParenthesis(int n) {

        if (n <= 0) return new ArrayList<>();

        List<List<String>> dp = new ArrayList<>();  // dp[i] = dp.get(i)
        List<String> dp0 = new ArrayList<String>() {{
            add("");
        }};
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1)
                    for (String s2 : str2)
                        cur.add("(" + s1 + ")" + s2);
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println((new Solution2()).generateParenthesis(n));
    }
}
