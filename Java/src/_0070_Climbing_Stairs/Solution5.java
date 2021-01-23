package _0070_Climbing_Stairs;

/**
 * Fibonacci Number - Binets Method
 * | F(n+1) F(n)   | = | 1 1 |^(n+1)
 * | F(n)   F(n-1) |   | 1 0 |
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
public class Solution5 {

    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        return pow(q, n)[0][0];
    }

    private int[][] pow(int[][] q, int n) {

        // 快速幂乘算法
        int[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) res = multiply(res, q);
            n >>= 1;
            q = multiply(q, q);
        }
        return res;
    }

    private int[][] multiply(int[][] a, int[][] b) {

        // 矩阵乘法
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
        return c;
    }

    public static void main(String[] args) {

        System.out.println((new Solution5()).climbStairs(7));
    }
}
