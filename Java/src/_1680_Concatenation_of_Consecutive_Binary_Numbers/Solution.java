package _1680_Concatenation_of_Consecutive_Binary_Numbers;

/**
 * Date: 2020/12/8 15:31
 * Content: 核心思想：二进制的变化 映射到 十进制对应的变换
 *
 * 执行用时：139 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.5 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution {

    public static final int MOD = 1000000007;

    // 返回数字 num 的二进制位数
    private int getLen(int num) {

        int res = 0;
        while (num > 0) {
            num >>= 1;
            res++;
        }
        return res;
    }

    public int concatenatedBinary(int n) {
//        int res = 0, shift = 0;
//        for (int i = 1; i <= n; i++) {
//            if ((i & (i - 1)) == 0) {
//                // 说明是2的幂，则进位
//                shift++;
//            }
//            res = (int) ((((long) res << shift) + i) % MOD);
//        }
//        return res;

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (int) ((((long) res << getLen(i)) + i) % MOD);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).concatenatedBinary(1));
        System.out.println((new Solution()).concatenatedBinary(3));
        System.out.println((new Solution()).concatenatedBinary(12));
    }
}
