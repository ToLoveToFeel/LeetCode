package _0493_Reverse_Pairs;

import java.util.*;

/**
 * Date: 2020/11/28 14:48
 * Content: 归并排序
 * <p>
 * 执行用时：56 ms, 在所有 Java 提交中击败了72.55%的用户
 * 内存消耗：46.2 MB, 在所有 Java 提交中击败了99.61%的用户
 */
public class Solution4 {

    // 归并，并统计逆序对个数
    private void merge(int[] nums, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(nums, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) {  // 左边的数据 <= 右边的数据
                nums[k] = aux[i - l];
                i++;
            } else {
                nums[k] = aux[j - l];
                j++;
            }
        }
    }

    // nums[l..r] 计算逆序对个数并且排序
    private int reversePairs(int[] nums, int l, int r) {

        if (l == r)
            return 0;

        int mid = (r - l) / 2 + l;
        int leftPairs = reversePairs(nums, l, mid);  // 计算nums[l..mid]逆序对个数并且排序
        int rightPairs = reversePairs(nums, mid + 1, r);  // 计算nums[mid+1..r]逆序对个数并且排序

        // 统计两个有序数组逆序对的数量
        int i = l, j = mid + 1;
        int count = 0;
        while (i <= mid && j <= r) {
            // 计算逆序对的数量
            if ((long) nums[i] > (long) nums[j] * 2) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        int pairs = leftPairs + rightPairs + count;

        // 判断是否需要归并
        if (nums[mid] > nums[mid + 1])
            merge(nums, l, mid, r);

        return pairs;
    }

    public int reversePairs(int[] nums) {

        int n = nums.length;
        if (n < 2)
            return 0;

        return reversePairs(nums, 0, n - 1);
    }


    public static void main(String[] args) {

        int[] nums = {12, 34, 24, 34, 12};  // 2
//        int[] nums = {-5, -5};  // 0
//        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println((new Solution4()).reversePairs(nums));
    }
}

