package _0279_Perfect_Squares;

import java.util.Arrays;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 完全背包问题
 * 执行用时：44 ms, 在所有 Java 提交中击败了47.00%的用户
 * 内存消耗：37.6 MB, 在所有 Java 提交中击败了58.43%的用户
 */
public class Solution3 {

    public int numSquares(int n) {

        int[] f = new int[n + 1];  // f[i] 代表 i 最少可以由几个完全平方数表示
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                // i本次次由完全平方数表示的个数 = min（i上次由完全平方数表示的个数，i - j * j由完全平方数表示的最少个数+1）
                f[i] = Math.min(f[i], 1 + f[i - j * j]);

        return f[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));  // 3
        System.out.println((new Solution3()).numSquares(13));  // 2
    }
}
