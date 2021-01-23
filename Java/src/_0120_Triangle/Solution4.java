package _0120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2020/8/31 15:23
 * Content:动态规划
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 * 执行用时：3 ms, 在所有 Java 提交中击败了71.73%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了77.51%的用户
 */
class Solution4 {

    // 状态dp[i][j]：从下向上 到达三角形位置(i, j)的最小路径和
    public int minimumTotal(List<List<Integer>> t) {

        int n = t.size();

        int[][] f = new int[n + 5][n + 5];
        for (int i = 1; i <= n; i++) f[n][i] = t.get(n - 1).get(i - 1);
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + t.get(i - 1).get(j - 1);
        }
        return f[1][1];
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
        System.out.println((new Solution4()).minimumTotal(triangle));
    }
}
