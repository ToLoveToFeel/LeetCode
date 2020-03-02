package _0056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    // 1、首先对列表中的元素基于第一个元素排序；
    // 2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对是重叠的，
    //    递归的执行这个过程，找到所有的重叠部分
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i+1 < intervals.length && intervals[i+1][0] <= right){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            res.add(new ArrayList<Integer>(Arrays.asList(left, right)));
        }

        int[][] ret = new int[res.size()][res.get(0).size()];
        for (int i = 0; i < res.size(); i++)
            for (int j = 0; j < res.get(0).size(); j++)
                ret[i][j] = res.get(i).get(j);

        return ret;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] ret = (new Solution()).merge(intervals);

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
