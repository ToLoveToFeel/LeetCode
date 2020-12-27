package _0056_Merge_Intervals;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        // 1、首先对列表中的元素基于第一个元素从小到大排序；
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对是重叠的，
        //    递归的执行这个过程，找到所有的重叠部分
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i + 1 < intervals.length && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            l.add(new ArrayList<>(Arrays.asList(left, right)));
        }
        // 整理结果
        int[][] res = new int[l.size()][l.get(0).size()];
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
