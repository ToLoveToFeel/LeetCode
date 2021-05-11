package _1734_Decode_XORed_Permutation;

import _0000_study._common.Output;

/**
 * Date: 2021/5/11 9:47
 * 执行用时：4 ms, 在所有 Java 提交中击败了30.00%的用户
 * 内存消耗：59.7 MB, 在所有 Java 提交中击败了76.67%的用户
 */
public class Solution {

    public int[] decode(int[] encoded) {

        int n = encoded.length + 1;
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) res[0] ^= i;
        for (int i = 1; i < n - 1; i += 2) res[0] ^= encoded[i];

        for (int i = 1; i < n; i++) res[i] = res[i - 1] ^ encoded[i - 1];
        return res;
    }

    public static void main(String[] args) {

        Output.OutputBasicArray1D((new Solution()).decode(new int[]{6, 5, 4, 6}));
    }
}
