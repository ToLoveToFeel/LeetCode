package _1310_XOR_Queries_of_a_Subarray;

import java.util.Arrays;

/**
 * Date: 2021/5/12 10:08
 * 执行用时：3 ms, 在所有 Java 提交中击败了31.47%的用户
 * 内存消耗：49.4 MB, 在所有 Java 提交中击败了26.29%的用户
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] ^ arr[i - 1];

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0] + 1, r = queries[i][1] + 1;
            res[i] = s[r] ^ s[l - 1];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3},
        };
        System.out.println(Arrays.toString((new Solution()).xorQueries(arr, queries)));  // [2, 7, 14, 8]
    }
}
