package _0455_Assign_Cookies;

import java.util.Arrays;

/**
 * Date: 2020/12/25 9:45
 * Content: 贪心
 * 执行用时：9 ms, 在所有 Java 提交中击败了19.68%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了83.00%的用户
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++)
            if (g[i] <= s[j]) {
                i++;
                res++;
            }
        return res;
    }

    public static void main(String[] args) {

        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println((new Solution()).findContentChildren(g, s));
    }
}
