package _0000_study._leetcode._lcp._LCP_07_numWays;

/**
 * Date: 2021/7/1 10:37
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.8 MB, 在所有 Java 提交中击败了80.30%的用户
 */
public class Solution {

    public int numWays(int n, int[][] relation, int k) {
        int[][] f = new int[k + 1][n];
        f[0][0] = 1;  // 经过0轮到达0的方案数为1
        for (int i = 1; i <= k; i++)
            for (int[] edge : relation)
                f[i][edge[1]] += f[i - 1][edge[0]];
        return f[k][n - 1];
    }

    public static void main(String[] args) {

        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println((new Solution()).numWays(5, relation, 3));  // 3
    }
}
