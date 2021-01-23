package _0057_Insert_Interval;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 执行用时：6 ms, 在所有 Java 提交中击败了9.19%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了97.29%的用户
 */

public class Solution {

    // 这道题和上一道类似，不过需要在最开始把新插入的区间放到列表中即可
    public int[][] insert(int[][] t1, int[] t2) {

        int n  = t1.length;
        // 1、将新元素插入数组，然后对列表中的元素基于第一个元素排序；
        int[][] t = new int[n + 1][2];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < t1[0].length; j++)
                t[i][j] = t1[i][j];
        t[n][0] = t2[0];
        t[n][1] = t2[1];

        Arrays.sort(t, (o1, o2) -> o1[0] - o2[0]);

        // 2、区间求并集
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            int left = t[i][0];
            int right = t[i][1];

            while (i + 1 < t.length && t[i + 1][0] <= right) {
                right = Math.max(t[i + 1][1], right);
                i++;
            }
            lists.add(new ArrayList<>(Arrays.asList(left, right)));
        }

        // 整理为数组返回
        int[][] res = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++)
            for (int j = 0; j < lists.get(0).size(); j++)
                res[i][j] = lists.get(i).get(j);
        return res;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] res = (new Solution()).insert(intervals, newInterval);

        Output.OutputBasicArray2D1(res);
    }
}
