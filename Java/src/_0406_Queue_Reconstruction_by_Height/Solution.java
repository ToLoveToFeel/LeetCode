package _0406_Queue_Reconstruction_by_Height;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/16 8:59
 * Content: 按照身高降序 K升序排序；然后将排序后数据依次插入list，先插入的数据一定是比较高的人
 * 执行用时：8 ms, 在所有 Java 提交中击败了90.65%的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了75.50%的用户
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // 如果身高相等(o1[0] == o2[0]) , 按照K降序排列(o2[0] - o1[0])
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });

        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {

        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Output.OutputBasicArray2D1((new Solution()).reconstructQueue(people));
    }
}
