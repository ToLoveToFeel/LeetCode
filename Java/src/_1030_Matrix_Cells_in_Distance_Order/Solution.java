package _1030_Matrix_Cells_in_Distance_Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/17 8:52
 * Content:
 * 执行用时：32 ms, 在所有 Java 提交中击败了10.10%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了93.89%的用户
 */
public class Solution {

    private int distance(int r, int c, int r0, int c0) {
        return Math.abs(r - r0) + Math.abs(c - c0);
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        // 第一步：生成待排序的二维数组，并得到各个点的距离，存入map中
        int[][] res = new int[R * C][2];
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j][0] = i;
                res[i * C + j][1] = j;
                int[] point = res[i * C + j];
                map.put(point, distance(i, j, r0, c0));
            }
        }

        // 第二步，根据得到的距离排序
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        return res;
    }

    public static void main(String[] args) {

        int R = 2, C = 3;
        int r0 = 1, c0 = 2;
        int[][] res = (new Solution()).allCellsDistOrder(R, C, r0, c0);
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1)
                System.out.print(Arrays.stream(res[i]).boxed().collect(Collectors.toList()) + ", ");
            else
                System.out.print(Arrays.stream(res[i]).boxed().collect(Collectors.toList()));
        }
        System.out.print("]");
    }
}
