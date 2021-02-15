package _0390_Elimination_Game;

/**
 * Date: 2021/2/15 22:50
 * Content:
 * 执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.1 MB, 在所有 Java 提交中击败了97.27%的用户
 */
public class Solution {

    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).lastRemaining(9));  // 6
    }
}
