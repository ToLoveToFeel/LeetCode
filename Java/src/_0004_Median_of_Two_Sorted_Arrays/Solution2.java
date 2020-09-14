package _0004_Median_of_Two_Sorted_Arrays;

/**
 * Date: 2020/9/14 11:23
 * Content:
 * 归并排序
 * 时间复杂度：O(m+n)    m和n是nums1和nums2的长度
 * 空间复杂度：O(1)
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 对于n个数，如果n为奇数：中间那个数是第 n / 2 + 1；如果n为偶数：中间两个数是第 n / 2 和 第 n / 2 + 1 个数
        int n = nums1.length + nums2.length;
        int pre = -1, cur = -1;

        int i = 0, j = 0;  // i指向nums1当前考察的元素，j指向nums2当前考察的元素
        for (int k = 0; k < n / 2 + 1; k++) {
            pre = cur;
            if (i >= nums1.length) {  // 如果左半部分元素已经全部处理完毕
                cur = nums2[j];
                j++;
            } else if (j >= nums2.length) {  // 如果右半部分元素已经全部处理完毕
                cur = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {  // 左半部分所指元素 < 右半部分所指元素
                cur = nums1[i];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                cur = nums2[j];
                j++;
            }
        }

        return ((n & 1) == 1) ? cur : ((cur + pre) / 2.0);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println((new Solution2()).findMedianSortedArrays(nums1, nums2));
    }
}
