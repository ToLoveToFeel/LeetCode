package _0324_Wiggle_Sort_II;

import _0000_study._common.Output;

/**
 * Date: 2021/2/24 10:08
 * Content:
 * 执行用时：22 ms, 在所有 Java 提交中击败了30.08%的用户
 * 内存消耗：42.7 MB, 在所有 Java 提交中击败了5.08%的用户
 */
public class Solution {

    // 返回 q[l...r]中第k小的数据
    private int quick_sort(int[] q, int l, int r, int k) {

        if (l == r) return q[l];

        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) swap(q, i, j);
        }

        int sl = j - l + 1;
        if (k <= sl) return quick_sort(q, l, j, k);
        return quick_sort(q, j + 1, r, k - sl);
    }

    private void swap(int[] q, int i, int j) {
        int t = q[i]; q[i] = q[j]; q[j] = t;
    }

    private int A(int n, int i) {
        return (i * 2 + 1) % (n | 1);
    }

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        // 必须+1，否则[1,3,2,2,2,1,1,3,1,1,2]无法通过
        int mid = quick_sort(nums, 0, n - 1, n / 2 + 1);

        for (int i = 0, j = 0, k = n - 1; i <= k; ) {
            if (nums[A(n, i)] > mid) swap(nums, A(n, i++), A(n, j++));
            else if (nums[A(n, i)] < mid) swap(nums, A(n, i), A(n, k--));
            else i++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 1, 1, 6, 4};
        (new Solution()).wiggleSort(nums);
        Output.OutputBasicArray1D(nums);
    }
}
