package _0221_Maximal_Square;

/**
 * Date: 2020/10/27 13:38
 * Content:
 * 暴力解法
 * 执行用时：4 ms, 在所有 Java 提交中击败了98.76%的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了98.06%的用户
 * <p>
 * 时间复杂度：O(m*n*min(m,n)^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxEdge = 0;
        int M = matrix.length, N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '0') continue;
                // 说明 matrix[i][j] == '1'，以此为基准进行扩展
                maxEdge = Math.max(maxEdge, 1);
                int curMaxEdge = Math.min(M - i, N - j);  // 计算可能的最大正方形边长
                for (int k = 1; k < curMaxEdge; k++) {
                    // 判断新增的一行一列是否全为 1
                    if (matrix[i + k][j + k] == '0') break;

                    boolean canExpend = true;
                    for (int l = 0; l < k; l++) {
                        if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {  // i+k这一行，j+k这一列
                            canExpend = false;
                            break;
                        }
                    }
                    if (canExpend) maxEdge = Math.max(maxEdge, k + 1);
                    else break;
                }
            }
        }
        return maxEdge * maxEdge;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println((new Solution()).maximalSquare(matrix));
    }
}
