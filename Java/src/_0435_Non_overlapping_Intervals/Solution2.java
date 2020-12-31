package _0435_Non_overlapping_Intervals;

import java.util.Arrays;

/**
 * Date: 2020/12/31 9:34
 * Content: 对有重叠的区间进行合并，最终得到的区间个数为不重叠的区间个数
 * 类似于 Leetcode 0452
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了30.00%的用户
 */
public class Solution2 {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) return 0;

        // 第一步：排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 统计存在重叠的区间求并集后剩余的区间
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            int right = intervals[i][1];

            while (i + 1 < n && intervals[i + 1][0] < right) {
                right = Math.min(right, intervals[i + 1][1]);
                i++;
            }
            cnt++;
        }

        return n - cnt;
    }

    public static void main(String[] args) {

//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println((new Solution2()).eraseOverlapIntervals(intervals));
    }
}
