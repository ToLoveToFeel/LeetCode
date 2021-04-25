package _0066_Plus_One;

import _0000_study._common.Output;

/**
 * Date: 2020/10/27 14:46
 * Content:
 */
public class Solution2 {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {

        int[] digits = {9, 9};
        Output.OutputBasicArray1D((new Solution2()).plusOne(digits));
    }
}
