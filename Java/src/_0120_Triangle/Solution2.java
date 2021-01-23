package _0120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2020/8/31 15:23
 * Content:
 * 记忆化搜索
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
class Solution2 {

    Integer[][] memo;

    private int go(List<List<Integer>> triangle, int i, int j) {

        if (memo[i][j] != -1) return memo[i][j];
        if (i == 0) return memo[i][j] = triangle.get(i).get(j);
        if (j == 0) return memo[i][j] = triangle.get(i).get(j) + go(triangle, i - 1, 0);
        if (j == i) return memo[i][j] = triangle.get(i).get(j) + go(triangle, i - 1, j - 1);
        return memo[i][j] = triangle.get(i).get(j) + Math.min(go(triangle, i - 1, j - 1),
                go(triangle, i - 1, j));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);

        memo = new Integer[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        for (int i = 0; i < n; i++) memo[n - 1][i] = go(triangle, n - 1, i);
        return Collections.min(Arrays.asList(memo[n - 1]));
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
        System.out.println((new Solution2()).minimumTotal(triangle));
    }
}
