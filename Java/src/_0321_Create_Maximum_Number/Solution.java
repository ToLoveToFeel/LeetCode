package _0321_Create_Maximum_Number;

import _0000_study._common.Output;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 2020/12/2 16:39
 * Content: 归并、单调栈
 * 执行用时：7 ms, 在所有 Java 提交中击败了98.31%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了29.87%的用户
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] a = maxArray(nums1, i), b = maxArray(nums2, k - i);
            int[] c = merge(a, b);
            if (compare(c, 0, res, 0) > 0) res = c;
        }
        return res;
    }

    // 按位比较a[i...]和b[j...]的大小
    private int compare(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) { i++; j++; continue; }
            return a[i] - b[j];
        }
        if (i < a.length) return 1;
        if (j < b.length) return -1;
        return 0;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            int x = nums[i];
            while (j > 0 && x > res[j - 1] && j + nums.length - i > k) j--;
            if (j < k) res[j++] = x;
        }
        return res;
    }

    private int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (compare(a, i, b, j) > 0) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while (i < a.length) c[k++] = a[i++];
        while (j < b.length) c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {

//        // [9, 8, 6, 5, 3]
//        int[] nums1 = {3, 4, 6, 5}, nums2 = {9, 1, 2, 5, 8, 3};
//        Output.OutputBasicArray1D((new Solution()).maxNumber(nums1, nums2, 5));

//        // [6, 7, 6, 0, 4]
//        int[] nums1 = {6, 7}, nums2 = {6, 0, 4};
//        Output.OutputBasicArray1D((new Solution()).maxNumber(nums1, nums2, 5));

        // [9, 8, 9]
        int[] nums1 = {3, 9}, nums2 = {8, 9};
        Output.OutputBasicArray1D((new Solution()).maxNumber(nums1, nums2, 3));
    }
}
