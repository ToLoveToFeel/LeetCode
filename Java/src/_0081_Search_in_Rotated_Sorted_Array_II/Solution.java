package _0081_Search_in_Rotated_Sorted_Array_II;

/**
 * Date: 2020/10/19 16:52
 * Content:
 * 在 Leetcode 上该解法可以得到通过
 * 执行用时：1 ms, 在所有 Java 提交中击败了70.83%的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了99.86%的用户
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        for (int num : nums)
            if (num == target)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 2;
        System.out.println((new Solution()).search(nums, target));
    }
}
