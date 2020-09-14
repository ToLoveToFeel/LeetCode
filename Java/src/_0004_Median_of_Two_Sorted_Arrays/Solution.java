package _0004_Median_of_Two_Sorted_Arrays;

/**
 * Date: 2020/9/14 11:23
 * Content:
 * 归并排序
 * 时间复杂度：O(m+n)    m和n是nums1和nums2的长度
 * 空间复杂度：O(m+n)
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums = new int[n];

        int i = 0, j = 0;  // i指向nums1当前考察的元素，j指向nums2当前考察的元素
        for (int k = 0; k < n; k++) {
            if (i >= nums1.length) {  // 如果左半部分元素已经全部处理完毕
                nums[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {  // 如果右半部分元素已经全部处理完毕
                nums[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {  // 左半部分所指元素 < 右半部分所指元素
                nums[k] = nums1[i];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                nums[k] = nums2[j];
                j++;
            }
        }

        return n % 2 == 1 ? nums[n / 2] : ((nums[(n - 1) / 2] + nums[n / 2]) / 2.0);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        System.out.println((new Solution()).findMedianSortedArrays(nums1, nums2));
    }
}
