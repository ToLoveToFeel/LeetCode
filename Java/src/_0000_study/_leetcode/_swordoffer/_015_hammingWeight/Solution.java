package _0000_study._leetcode._swordoffer._015_hammingWeight;

/**
 * Date: 2021/6/23 9:00
 * 执行用时：1 ms, 在所有 Java 提交中击败了96.63%的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了41.94%的用户
 */
public class Solution {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) res += (n >> i & 1);
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).hammingWeight(13));  // 3
        System.out.println((new Solution()).hammingWeight(0b11111111111111111111111111111101));  // 31
    }
}
