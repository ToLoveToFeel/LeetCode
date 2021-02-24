package _0279_Perfect_Squares;

import java.util.Arrays;

/**
 * 时间复杂度：O(n*sqrt(n))
 * 空间复杂度：O(n)
 * 完全背包问题
 * 执行用时：30 ms, 在所有 Java 提交中击败了86.04%的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了34.09%的用户
 */
public class Solution3 {

    public int numSquares(int n) {

        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i * i <= n; i++)  // 先循环物品 i*i
            for (int j = i * i; j <= n; j++)  // 再循环体积：体积从i*i开始
                f[j] = Math.min(f[j], f[j - i * i] + 1);

        return f[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));  // 3
        System.out.println((new Solution3()).numSquares(13));  // 2
    }
}
