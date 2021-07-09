package _0000_study._leetcode._interview._01_08_Zero_Matrix;

/**
 * Date: 2020/9/18 16:18
 * Content:
 */
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        // 第一步：记录第一行、第一列是否有 0
        boolean setRow0Zero = false;
        boolean setColumn0Zero = false;
        for (int j = 0; j < n; j++) {  // 第一行
            if (matrix[0][j] == 0) {
                setRow0Zero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {  // 第一列
            if (matrix[i][0] == 0) {
                setColumn0Zero = true;
                break;
            }
        }

        // 第二步：遍历除第一行和第一列的其余数据，如果存在 0 的话，将 matrix[..][0] 和 matrix[0][..]置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 第三步：根据第一行和第一列是否为 0,将相应的行和列置零
        for (int i = 1; i < m; i++) {  // 将行置零
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 第四步：检查第一行和第一列是否需要置零
        if (setRow0Zero) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
        if (setColumn0Zero) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        (new Solution2()).setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
