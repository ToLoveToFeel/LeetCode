package _0342_Power_of_Four;

/**
 * Created by WXX on 2021/2/25 21:54
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.6 MB, 在所有 Java 提交中击败了30.10%的用户
 */
public class Solution {

    public boolean isPowerOfFour(int n) {

        if (n <= 0) return false;
        int r = (int) Math.sqrt(n);
        if (r * r != n) return false;
        return (1 << 30) % n == 0;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isPowerOfFour(16));  // true
        System.out.println((new Solution()).isPowerOfFour(5));  // false
        System.out.println((new Solution()).isPowerOfFour(1));  // true
    }
}
