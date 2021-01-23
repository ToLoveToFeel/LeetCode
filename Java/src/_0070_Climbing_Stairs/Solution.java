package _0070_Climbing_Stairs;

/**
 * 时间复杂度：O(2^n)
 *     // k空间复杂度：O(2^n)
 */
public class Solution {

    public int climbStairs(int n) {

        if (n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).climbStairs(3));  // 3
    }
}
