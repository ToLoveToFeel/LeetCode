package _0056_Merge_Intervals;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) return intervals;

        // 1、首先对列表中的元素基于第一个元素从小到大排序；
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 2、区间求并集
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i + 1 < n && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            l.add(new ArrayList<>(Arrays.asList(left, right)));
        }

        // 整理结果
        int[][] res = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(0).size(); j++)
                res[i][j] = l.get(i).get(j);
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = (new Solution()).merge(intervals);

        Output.OutputBasicArray2D(res);
    }
}
