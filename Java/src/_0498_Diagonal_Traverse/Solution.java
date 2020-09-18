package _0498_Diagonal_Traverse;

/**
 * Date: 2020/9/18 20:29
 * Content:
 */
public class Solution {
    // 某条和副对角线平行的数据下标之和为定值
    // 对于 n x n 的数组，一共有 2n-1 调对角线，和为[0, ..., 2n-2]
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[]{};
        int n = matrix[0].length;
        int maxLength = Math.max(m, n);  // 找到数组比较大的一个维度，则有 2 * maxLength - 1 条对角线需要处理
        int[] res = new int[m * n];
        int index = 0;

        for (int i = 0; i < 2 * maxLength - 1; i++) {
            if (i % 2 == 0) {  // 左下到右上
                int startX = Math.min(i, m - 1);
                int endX = i - Math.min(i, n - 1);
                for (int j = startX; j >= endX; j--)  // 此时 j 代表横坐标
                    res[index++] = matrix[j][i - j];
            } else {  // 右上到左下
                int startY = Math.min(i, n - 1);
                int endY = i - Math.min(i, m - 1);
                for (int j = startY; j >= endY; j--)  // 此时 j 代表纵坐标
                    res[index++] = matrix[i - j][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // 1 2 4 7 5 3 6 8 9
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};  // 1 2 4 5 3 6
        int[][] matrix = {{1, 2}, {4, 5}, {7, 8}};  // 1 2 4 7 5 8
        int[] newMatrix = (new Solution()).findDiagonalOrder(matrix);
        for (int num : newMatrix) {
            System.out.print(num + " ");
        }
    }
}
