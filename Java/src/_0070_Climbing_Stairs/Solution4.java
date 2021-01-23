package _0070_Climbing_Stairs;

/**
 * Fibonacci Number
 * f0 = 0, f(1) = 1, f(2) = 1, f(3) = 2...
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution4 {

    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int prev = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            int f = cur + prev;
            prev = cur;
            cur = f;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println((new Solution4()).climbStairs(3));
    }
}
