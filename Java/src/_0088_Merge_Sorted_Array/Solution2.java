package _0088_Merge_Sorted_Array;

import _0000_study._common.Output;

/**
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = m + n;

        for (int i = n + m - 1; i >= n; i--)  // nums1元素整体向后移动n个元素
            nums1[i] = nums1[i - n];

        int i = n;  // pointer for nums1 [n, n+m)
        int j = 0;  // pointer for nums2 [0, n)
        int k = 0;  // pointer merged nums1 [0, n+m)

        while (k < length) {
            if (i >= length)
                nums1[k++] = nums2[j++];
            else if (j >= n)
                nums1[k++] = nums1[i++];
            else if (nums1[i] > nums2[j])
                nums1[k++] = nums2[j++];
            else
                nums1[k++] = nums1[i++];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        (new Solution2()).merge(nums1, m, nums2, n);
        Output.OutputBasicArray1D(nums1);
    }
}
