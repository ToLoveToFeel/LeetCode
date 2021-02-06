package _0292_Nim_Game;

/**
 * Date: 2021/2/6 10:35
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了14.31%的用户
 */
public class Solution {

    public boolean canWinNim(int n) {

        return n % 4 >= 1;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).canWinNim(4));  // false
        System.out.println((new Solution()).canWinNim(1));  // true
    }
}
