package _0057_Insert_Interval;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了46.07%的用户
 * 内存消耗：40.7 MB, 在所有 Java 提交中击败了86.97%的用户
 */
public class Solution2 {

    // [[1,2],[3,5],[6,7],[8,10],[12,16]]
    //         [4,         8]
    public int[][] insert(int[][] t1, int[] t2) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        int cur = 0;  // 找到第一处newInterval区间左边的值 小于或等于 intervals区间右边的值的位置
        while (cur < t1.length && t1[cur][1] < t2[0]) {
            lists.add(new ArrayList<>(Arrays.asList(t1[cur][0], t1[cur][1])));
            cur++;
        }

        while (cur < t1.length && t1[cur][0] <= t2[1]) {
            t2[0] = Math.min(t1[cur][0], t2[0]);
            t2[1] = Math.max(t1[cur][1], t2[1]);
            cur++;
        }
        lists.add(new ArrayList<>(Arrays.asList(t2[0], t2[1])));

        while (cur < t1.length) {
            lists.add(new ArrayList<>(Arrays.asList(t1[cur][0], t1[cur][1])));
            cur++;
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
        int[][] res = (new Solution2()).insert(intervals, newInterval);

        Output.OutputBasicArray2D1(res);
    }
}
