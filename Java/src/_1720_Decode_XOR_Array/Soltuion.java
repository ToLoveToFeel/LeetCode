package _1720_Decode_XOR_Array;

import _0000_study._common.Output;

/**
 * Date: 2021/5/6 8:54
 * 执行用时：2 ms, 在所有 Java 提交中击败了73.79%的用户
 * 内存消耗：39.4 MB, 在所有 Java 提交中击败了58.17%的用户
 */
public class Soltuion {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) res[i + 1] = res[i] ^ encoded[i];
        return res;
    }

    public static void main(String[] args) {

        Output.OutputBasicArray1D((new Soltuion()).decode(new int[]{1, 2, 3}, 1));  // [1, 0, 2, 1]
    }
}
