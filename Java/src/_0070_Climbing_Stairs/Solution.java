package _0070_Climbing_Stairs;

public class Solution {
    // 递归
    // 时间复杂度：O(2^n)
    // k空间复杂度：O(2^n)
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).climbStairs(3));
    }
}
