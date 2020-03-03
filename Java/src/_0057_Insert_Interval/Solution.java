package _0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    // 1、将新元素插入数组，然后对列表中的元素基于第一个元素排序；
    // 2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对
    //    是重叠的，重复的执行这个过程，找到所有的重叠部分；
    // 3、这道题和上一道类似，不过需要在最开始把新插入的区间放到列表中即可
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length+1][2];

        for (int i = 0; i < intervals.length; i++)
            for (int j = 0; j< intervals[0].length; j++)
                newIntervals[i][j] = intervals[i][j];
        newIntervals[intervals.length][0] = newInterval[0];
        newIntervals[intervals.length][1] = newInterval[1];

        Arrays.sort(newIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < newIntervals.length; i++){
            int left = newIntervals[i][0];
            int right = newIntervals[i][1];

            while (i+1 < newIntervals.length && newIntervals[i+1][0] <= right){
                right = Math.max(newIntervals[i+1][1], right);
                i++;
            }
            res.add(new ArrayList<>(Arrays.asList(left, right)));
        }

        // 整理为数组返回
        int[][] ret = new int[res.size()][res.get(0).size()];
        for (int i = 0; i < res.size(); i++)
            for (int j = 0; j < res.get(0).size(); j++)
                ret[i][j] = res.get(i).get(j);

        return ret;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };

        int[] newInterval = {4, 8};

        int[][] ret = (new Solution()).insert(intervals, newInterval);

        for (int i = 0; i < ret.length; i++){
            System.out.print("[");
            for (int j = 0; j < ret[0].length; j++){
                System.out.print(ret[i][j]);
                if (j == 0)
                    System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}
