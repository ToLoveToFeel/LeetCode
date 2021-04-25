package _0066_Plus_One;

import _0000_study._common.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2020/10/27 14:46
 * Content:
 */
public class Solution {

    public int[] plusOne(int[] digits) {

        List<Integer> list = new ArrayList<>();

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            int num = (digit + carry) % 10;
            carry = (digit + carry) / 10;
            list.add(num);
        }
        if (carry == 1) list.add(carry);

        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }

    public static void main(String[] args) {

        int[] digits = {9, 9};
        Output.OutputBasicArray1D((new Solution()).plusOne(digits));
    }
}
