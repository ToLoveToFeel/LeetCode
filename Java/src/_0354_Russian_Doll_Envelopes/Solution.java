package _0354_Russian_Doll_Envelopes;

import java.util.Arrays;

/**
 * Created by WXX on 2021/3/4 9:28
 * LIS问题
 * 这个解法的关键在于，对于宽度 w 相同的数对，要对其高度 h 进行降序排序。
 * 因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个。
 * 执行用时：11 ms, 在所有 Java 提交中击败了98.52%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了64.24%的用户
 */
public class Solution {

    public int maxEnvelopes(int[][] w) {

        int n = w.length;
        Arrays.sort(w, (o1, o2) -> {
            return o1[0] == o2[0] ? o2[1] -o1[1] : o1[0] - o2[0];
        });
        int[] q = new int[n + 1];

        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < w[i][1]) l = mid;
                else r = mid - 1;
            }
            res = Math.max(res, r + 1);
            q[r + 1] = w[i][1];
        }
        return res;
    }

    public static void main(String[] args) {

//        int[][] w = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
//        System.out.println((new Solution()).maxEnvelopes(w));

        int[][] w = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println((new Solution()).maxEnvelopes(w));
    }
}
