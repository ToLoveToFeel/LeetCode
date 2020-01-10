package _0279_Perfect_Squares;

import java.util.Arrays;

public class Solution3 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // 动态编程，掌握
    public int numSquares(int n) {

        int[] mem = new int[n+1];  // mem[i] 代表 i可以由几个完全平方数表示
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for(int i = 1; i <= n ; i ++)
            for(int j = 1 ; i - j * j >= 0 ; j ++)
                // i本次次由完全平方数表示的个数 = min（i上次由完全平方数表示的个数，i - j * j由完全平方数表示的最少个数+1）
                mem[i] = Math.min(mem[i], 1 + mem[i - j * j]);

        return mem[n];
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }
}
