package _0304_Range_Sum_Query_2D_Immutable;

/**
 * Date: 2021/2/9 10:48
 * Content: 二维前缀和
 * 执行用时：14 ms, 在所有 Java 提交中击败了98.50%的用户
 * 内存消耗：44.4 MB, 在所有 Java 提交中击败了5.32%的用户
 */
public class NumMatrix {

    int[][] s;

    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        x1++;
        y1++;
        x2++;
        y2++;
        return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix t = new NumMatrix(matrix);
        System.out.println(t.sumRegion(2, 1, 4, 3));  // 8
        System.out.println(t.sumRegion(1, 1, 2, 2));  // 11
        System.out.println(t.sumRegion(1, 2, 2, 4));  // 12
    }
}
