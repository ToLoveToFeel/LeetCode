package _0120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2020/8/31 15:23
 * Content:
 * 动态规划
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
class Solution3 {

    Integer[][] dp;

    // 状态dp[i][j]：从上到下 到达三角形位置(i, j)的最小路径和
    public int minimumTotal(List<List<Integer>> t) {

        int n = t.size();
        if (n == 0) return 0;
        if (n == 1) return t.get(0).get(0);
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        dp[0][0] = t.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < t.get(i).size(); j++) {
                if (j == 0) dp[i][j] = t.get(i).get(j) + dp[i - 1][j];
                else if (j == i) dp[i][j] = t.get(i).get(j) + dp[i - 1][j - 1];
                else dp[i][j] = t.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        return Collections.min(Arrays.asList(dp[n - 1]));
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {{
            add(2);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        System.out.println((new Solution3()).minimumTotal(triangle));
    }
}
