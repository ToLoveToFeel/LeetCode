package _1030_Matrix_Cells_in_Distance_Order;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/17 8:52
 * Content: 广度优先遍历
 * 执行用时：11 ms, 在所有 Java 提交中击败了86.80%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了98.23%的用户
 */
public class Solution2 {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 上右下左
    boolean[][] visited;

    private boolean inArea(int R, int C, int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        visited = new boolean[R][C];

        int[][] res = new int[R * C][2];
        int index = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});
        visited[r0][c0] = true;
        res[index][0] = r0;
        res[index][1] = c0;
        index++;
        while (!queue.isEmpty()) {
            int[] point = queue.remove();
            for (int j = 0; j < d.length; j++) {
                int r = point[0] + d[j][0];
                int c = point[1] + d[j][1];
                if (inArea(R, C, r, c) && !visited[r][c]) {
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                    res[index][0] = r;
                    res[index][1] = c;
                    index++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int R = 2, C = 3;
        int r0 = 1, c0 = 2;
        int[][] res = (new Solution2()).allCellsDistOrder(R, C, r0, c0);
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
