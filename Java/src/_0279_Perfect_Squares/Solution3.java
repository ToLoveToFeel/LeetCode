package _0279_Perfect_Squares;

import java.util.Arrays;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 完全背包问题
 */
public class Solution3 {

    public int numSquares(int n) {

        int[] f = new int[n + 1];  // f[i] 代表 i可以由几个完全平方数表示
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                // i本次次由完全平方数表示的个数 = min（i上次由完全平方数表示的个数，i - j * j由完全平方数表示的最少个数+1）
                f[i] = Math.min(f[i], 1 + f[i - j * j]);

        return f[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));  // 2
        System.out.println((new Solution3()).numSquares(13));  // 3
    }
}
