package _1232_Check_If_It_Is_a_Straight_Line;

/**
 * Date: 2021/1/17 9:31 上午
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了87.10%的用户
 */
public class Solution {

    public boolean checkStraightLine(int[][] c) {

        if (c.length == 0) return true;

        if (c[0][0] == c[1][0]) {  // 说明是垂直于x轴
            for (int i = 2; i < c.length; i++)
                if (c[i][0] != c[0][0])
                    return false;
        } else {
            int x1 = c[0][0], y1 = c[0][1], x2 = c[1][0], y2 = c[1][1];
            // 两点式
            for (int i = 2; i < c.length; i++) {
                if ((x1 - x2) * (c[i][1] - y2) != (y1 - y2) * (c[i][0] - x2))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        int[][] c = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};  // true
        int[][] c = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}};  // false
        System.out.println((new Solution()).checkStraightLine(c));

    }
}
