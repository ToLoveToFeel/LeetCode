package _0861_Score_After_Flipping_Matrix;

/**
 * Date: 2020/12/7 9:20
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36 MB, 在所有 Java 提交中击败了91.53%的用户
 */
public class Solution {

    // 计算 A 中第 j 列 0 的个数
    private int countZero(int[][] A, int j, int m) {

        int res = 0;
        for (int i = 0; i < m; i++)
            if (A[i][j] == 0)
                res++;

        return res;
    }

    public int matrixScore(int[][] A) {

        int m = A.length;
        int n = A[0].length;
        int[] counts = new int[n];  // 记录每列 1 的个数，方便最后计算结果

        // 第一步：对每一行进行处理，如果每一行的第一个元素为0，这一行全体翻转
        for (int i = 0; i < m; i++)
            if (A[i][0] == 0)
                for (int j = 0; j < n; j++)   // 翻转数据的某一行
                    A[i][j] ^= 1;
        counts[0] = m;

        // 第二步：从第二列开始处理，计算 1 和 0 的个数，如果 0 的个数比较多，翻转这一行
        // 为了节省时间，可以不用翻转，直接记录该列中反转后 1 的个数即可
        for (int j = 1; j < n; j++) {
            int zeroNum = countZero(A, j, m);
            counts[j] = Math.max(zeroNum, m - zeroNum);
        }

        // 第三步：计算结果
        int res = 0;
        for (int i = counts.length - 1; i >= 0; i--)
            res += (counts[i] << (counts.length - 1 - i));

        return res;
    }

    public static void main(String[] args) {

        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println((new Solution()).matrixScore(A));
    }
}
