package _0435_Non_overlapping_Intervals;

import java.util.Arrays;

/**
 * Date: 2020/12/31 9:34
 * Content: 对区间右端点排序
 * 执行用时：4 ms, 在所有 Java 提交中击败了51.09%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了21.08%的用户
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] q) {

        if (q.length == 0) return 0;
        Arrays.sort(q, (o1, o2) -> o1[1] - o2[1]);
        int res = 1, r = q[0][1];
        for (int i = 1; i < q.length; i++)
            if (q[i][0] >= r) {
                res++;
                r = q[i][1];
            }
        return q.length - res;
    }

    public static void main(String[] args) {

//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println((new Solution()).eraseOverlapIntervals(intervals));
    }
}
