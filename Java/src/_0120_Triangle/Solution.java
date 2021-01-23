package _0120_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/8/31 15:23
 * Content:
 * 超出时间限制，Solution2为该方式的优化（记忆化搜索）
 */
class Solution {

    private int go(List<List<Integer>> triangle, int i, int j) {

        if (i == 0) return triangle.get(i).get(j);
        if (j == 0) return triangle.get(i).get(j) + go(triangle, i - 1, 0);
        if (j == i) return triangle.get(i).get(j) + go(triangle, i - 1, j - 1);
        return triangle.get(i).get(j) + Math.min(go(triangle, i - 1, j - 1),
                go(triangle, i - 1, j));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = Math.min(go(triangle, n - 1, i), res);

        return res;
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
        System.out.println((new Solution()).minimumTotal(triangle));
    }
}
