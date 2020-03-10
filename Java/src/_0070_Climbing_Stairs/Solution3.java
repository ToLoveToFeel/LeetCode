package _0070_Climbing_Stairs;

import java.util.Arrays;

public class Solution3 {
    // 动态规划
    // 时间复杂度：O(n)
    // k空间复杂度：O(n)
    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);

        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i-1] + memo[i-2];
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println((new Solution3()).climbStairs(3));
    }
}
