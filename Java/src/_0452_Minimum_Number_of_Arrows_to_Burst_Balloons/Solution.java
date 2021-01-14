package _0452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Date: 2020/11/23 9:07
 * Content:
 * <p>
 * 执行用时：21 ms, 在所有 Java 提交中击败了50.58%的用户
 * 内存消耗：46.4 MB, 在所有 Java 提交中击败了5.05%的用户
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if (n == 0) return 0;

        // 第一步：根据point[i][0]从小到大进行排序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 第二步：合并区间(不同于Leetcode 0056寻找并集,这里找的区间是交集)，根据剩余区间的个数，得到结果
        int res = 0;
        for (int i = 0; i < n; i++) {

            int right = points[i][1];

            while (i + 1 < points.length && points[i + 1][0] <= right) {
                right = Math.min(right, points[i + 1][1]);
                i++;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {

//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};  // 2
//        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};  // 4
//        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};  // 2
//        int[][] points = {{1, 2}};  // 1
//        int[][] points = {{2, 3}, {2, 3}};  // 1
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};  // 2
        System.out.println((new Solution()).findMinArrowShots(points));
    }
}
