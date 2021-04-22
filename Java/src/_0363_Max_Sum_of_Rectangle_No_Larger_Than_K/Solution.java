package _0363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.TreeSet;

/**
 * Date: 2021/4/22 9:36
 * 执行用时：221 ms, 在所有 Java 提交中击败了37.40%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了41.07%的用户
 */
public class Solution {

    int[][] sum;  // 二维前缀和

    private int get(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }

    public int maxSumSubmatrix(int[][] w, int K) {

        int n = w.length, m = w[0].length;
        sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + w[i - 1][j - 1];

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++)
            for (int j = i; j <= m; j++) {
                TreeSet<Integer> S = new TreeSet<>();
                S.add(0);
                for (int k = 1; k <= n; k++) {
                    int s2 = get(1, i, k, j);
                    Integer s1 = S.ceiling(s2 - K);
                    if (s1 != null) res = Math.max(res, s2 - s1);
                    S.add(s2);
                }
            }
        return res;
    }

    public static void main(String[] args) {

        int[][] w = {
                {1, 0, 1},
                {0, -2, 3},
        };
        System.out.println((new Solution()).maxSumSubmatrix(w, 2));  // 2
    }
}
