package _0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 执行用时：6 ms, 在所有 Java 提交中击败了9.19%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了97.29%的用户
 */

public class Solution {
    // 这道题和上一道类似，不过需要在最开始把新插入的区间放到列表中即可
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 1、将新元素插入数组，然后对列表中的元素基于第一个元素排序；
        int[][] newIntervals = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++)
            for (int j = 0; j < intervals[0].length; j++)
                newIntervals[i][j] = intervals[i][j];
        newIntervals[intervals.length][0] = newInterval[0];
        newIntervals[intervals.length][1] = newInterval[1];

        Arrays.sort(newIntervals, (o1, o2) -> o1[0] - o2[0]);

        // 2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对
        //    是重叠的，重复的执行这个过程，找到所有的重叠部分；
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < newIntervals.length; i++) {
            int left = newIntervals[i][0];
            int right = newIntervals[i][1];

            while (i + 1 < newIntervals.length && newIntervals[i + 1][0] <= right) {
                right = Math.max(newIntervals[i + 1][1], right);
                i++;
            }
            lists.add(new ArrayList<>(Arrays.asList(left, right)));
        }

        // 整理为数组返回
        int[][] res = new int[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++)
            for (int j = 0; j < lists.get(0).size(); j++)
                res[i][j] = lists.get(i).get(j);

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] res = (new Solution()).insert(intervals, newInterval);

        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
                if (j == 0)
                    System.out.print(" ");
            }
            if (i != res.length - 1)
                System.out.print("], ");
            else
                System.out.print("]");
        }
        System.out.println("]");
    }
}
