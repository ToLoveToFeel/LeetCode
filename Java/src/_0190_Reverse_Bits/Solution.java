package _0190_Reverse_Bits;

/**
 * Date: 2021/1/30 14:55
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了65.55%的用户
 */
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++)
            res = res * 2 + (n >> i & 1);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).reverseBits(43261596));  // 964176192
    }
}
