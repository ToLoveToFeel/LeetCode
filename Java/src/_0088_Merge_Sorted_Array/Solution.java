package _0088_Merge_Sorted_Array;

public class Solution {
    // 时间复杂度：O(m+n)
    // 空间复杂度：O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        if(length == 0)
            return;
        int[] aux = new int[length];
        int i = 0;  // nums1[0...i)已经遍历过
        int j = 0;  // nums2[0...j)已经遍历过
        int k = 0;  // aux[0...k)已经排好序
        while (k < length){
            if (i >= m)
                aux[k++] = nums2[j++];
            else if (j >= n)
                aux[k++] = nums1[i++];
            else if (nums1[i] > nums2[j])
                aux[k++] = nums2[j++];
            else
                aux[k++] = nums1[i++];
        }
        for (int ii = 0; ii < length; ii++)
            nums1[ii] = aux[ii];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        (new Solution()).merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++)
            System.out.println(nums1[i]);
    }
}
