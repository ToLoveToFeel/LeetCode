package _0000_study._leetcode._swordoffer._062_lastRemaining;

/**
 * Date: 2021/5/30 19:28
 * 执行用时：13 ms, 在所有 Java 提交中击败了27.47%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了23.37%的用户
 */
public class Solution {

    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lastRemaining(5, 3));
    }
}
