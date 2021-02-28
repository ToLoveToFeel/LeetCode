package _0338_Counting_Bits;

import _0000_study._common.Output;

/**
 * Created by WXX on 2021/2/28 10:20
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.95%的用户
 * 内存消耗：42.9 MB, 在所有 Java 提交中击败了5.20%的用户
 */
public class Solution {

    public int[] countBits(int num) {

        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {

        Output.OutputBasicArray1D((new Solution()).countBits(2));  // [0, 1, 1]
        Output.OutputBasicArray1D((new Solution()).countBits(5));  // [0, 1, 1, 2, 1, 2]
    }
}
