package _0231_Power_of_Two;

/**
 * Created by WXX on 2021/2/25 21:47
 * lowbit
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.7 MB, 在所有 Java 提交中击败了11.26%的用户
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isPowerOfTwo(1));  // true
        System.out.println((new Solution()).isPowerOfTwo(16));  // true
        System.out.println((new Solution()).isPowerOfTwo(218));  // false
    }
}
