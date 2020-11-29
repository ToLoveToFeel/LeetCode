package _0000_study._leetcode._swordoffer._051_reversePairs;

import java.util.Arrays;

/**
 * Date: 2020/11/29 10:47
 * Content: 归并排序
 * <p>
 * 执行用时：38 ms, 在所有 Java 提交中击败了52.37%的用户
 * 内存消耗：46.7 MB, 在所有 Java 提交中击败了97.08%的用户
 */
public class Solution4 {

    // 归并，并统计逆序对个数
    private int merge(int[] nums, int l, int mid, int r) {

        int count = 0;  // 存储逆序对的个数
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

                // 计算逆序对的数量
                count += (mid - i + 1);
            }
        }

        return count;
    }

    // nums[l..r] 计算逆序对个数并且排序
    private int reversePairs(int[] nums, int l, int r) {

        if (l == r)
            return 0;

        int mid = (r - l) / 2 + l;
        int leftPairs = reversePairs(nums, l, mid);  // 计算nums[l..mid]逆序对个数并且排序
        int rightPairs = reversePairs(nums, mid + 1, r);  // 计算nums[mid+1..r]逆序对个数并且排序

        int pairs = leftPairs + rightPairs;
        // 判断是否需要归并
        if (nums[mid] > nums[mid + 1])
            pairs += merge(nums, l, mid, r);

        return pairs;
    }

    public int reversePairs(int[] nums) {

        int n = nums.length;
        if (n < 2)
            return 0;

        return reversePairs(nums, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};  // 5
        System.out.println((new Solution4()).reversePairs(nums));
    }
}
