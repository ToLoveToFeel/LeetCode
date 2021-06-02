package _0441_Arranging_Coins;

/**
 * Date: 2021/6/2 20:12
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.8 MB, 在所有 Java 提交中击败了14.86%的用户
 */
public class Solution {

    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).arrangeCoins(5));
        System.out.println((new Solution()).arrangeCoins(8));
    }
}
