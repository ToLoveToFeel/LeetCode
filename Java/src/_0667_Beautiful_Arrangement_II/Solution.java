package _0667_Beautiful_Arrangement_II;

import _0000_study._common.Output;

/**
 * Created by WXX on 2021/3/3 9:59
 * 执行用时：1 ms, 在所有 Java 提交中击败了91.74%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了56.20%的用户
 */
public class Solution {

    public int[] constructArray(int n, int k) {

        int[] res = new int[n];
        for (int i = 0; i < n - k - 1; i++) res[i] = i + 1;
        int u = n - k - 1;
        int i = n - k, j = n;
        while (u < n) {
            res[u++] = i++;
            if (u < n) res[u++] = j--;
        }
        return res;
    }

    public static void main(String[] args) {

        Output.OutputBasicArray1D((new Solution()).constructArray(3, 1));  // [1, 2, 3]
        Output.OutputBasicArray1D((new Solution()).constructArray(3, 2));  // [1, 3, 2]
    }
}
