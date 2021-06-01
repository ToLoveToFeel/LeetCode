package _1744_Can_You_Eat_Your_Favorite_Candy_on_Your_Favorite_Day;

import java.util.Arrays;

/**
 * Date: 2021/6/1 10:35
 * 执行用时：11 ms, 在所有 Java 提交中击败了23.94%的用户
 * 内存消耗：75.2 MB, 在所有 Java 提交中击败了80.99%的用户
 */
public class Solution {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + candiesCount[i - 1];
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int type = q[0], day = q[1], cap = q[2];
            long x1 = day + 1, y1 = (long) (day + 1) * cap;
            long x2 = s[type] + 1, y2 = s[type + 1];
            res[i] = !(x1 > y2 || x2 > y1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] candiesCount = {
                7, 4, 5, 3, 8
        };
        int[][] queries = {
                {0, 2, 2},
                {4, 2, 4},
                {2, 3, 1000000000},
        };
        System.out.println(Arrays.toString((new Solution()).canEat(candiesCount, queries)));
    }
}
