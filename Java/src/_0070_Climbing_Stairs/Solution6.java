package _0070_Climbing_Stairs;

/**
 * Fibonacci Number - Closed Formula
 * Fn = 1/sqrt(5) * {[(1+sqrt(5))/2]^n - [(1-sqrt(5))/2]^n}
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
public class Solution6 {

    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5.0);
        return (int) ((Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1)) / sqrt5);
    }

    public static void main(String[] args) {

        System.out.println((new Solution6()).climbStairs(3));
    }
}
