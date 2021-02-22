package _0397_Integer_Replacement;

/**
 * Date: 2021/2/22 15:07
 * Content:
 * 执行用时：21 ms, 在所有 Java 提交中击败了11.58%的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了74.35%的用户
 */
public class Solution {

    public int integerReplacement(int n) {
        return f(n);
    }

    private int f(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return f(n / 2) + 1;
        return Math.min(f(n + 1), f(n - 1)) + 1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).integerReplacement(8));  // 3
        System.out.println((new Solution()).integerReplacement(7));  // 4
        System.out.println((new Solution()).integerReplacement(2147483647));  // 32
    }
}
