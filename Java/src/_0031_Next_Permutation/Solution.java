package _0031_Next_Permutation;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/10 9:18
 * Content:
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.72%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了63.16%的用户
 */
public class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        // 特殊情况判断
        int n = nums.length;
        if (n <= 1)
            return;
        // 寻找 nums[i] < num[j] 的位置, 则num[j...n-1]为降序(非严格)
        int i = n - 2, j = n - 1;
        for (; i >= 0; i--, j--) {
            if (nums[i] < nums[j])
                break;
        }
        // 在[j...n-1]从右向左寻找索引k，找到第一个nums[k] > nums[i]的位置，并交换位置
        if (i >= 0) {  // 说明不是最后一个排列
            int k = n - 1;
            while (nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }

        // 对nums[j...n-1]这个降序数组 转为 升序数组
        int begin = j, end = n - 1;
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }

//        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};  // [1, 3, 2]
//        int[] nums = {3, 2, 1};  // [1, 2, 3]
        int[] nums = {1, 1, 5};  // [1, 5, 1]
        (new Solution()).nextPermutation(nums);
    }
}
