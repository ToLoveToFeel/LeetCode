package _0057_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    // [[1,2],[3,5],[6,7],[8,10],[12,16]]
    //         [4,         8]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int cur = 0;
        while (cur < intervals.length && intervals[cur][1] < newInterval[0]) {
            res.add(new ArrayList<>(Arrays.asList(intervals[cur][0], intervals[cur][1])));
            cur++;
        }

        while (cur < intervals.length && intervals[cur][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[cur][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[cur][1], newInterval[1]);
            cur++;
        }
        res.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));

        while (cur < intervals.length) {
            res.add(new ArrayList<>(Arrays.asList(intervals[cur][0], intervals[cur][1])));
            cur++;
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

        int[][] ret = (new Solution2()).insert(intervals, newInterval);

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
