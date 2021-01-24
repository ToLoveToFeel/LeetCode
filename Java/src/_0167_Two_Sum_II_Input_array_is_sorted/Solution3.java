package _0167_Two_Sum_II_Input_array_is_sorted;

import _0000_study._common.Output;

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：1 ms, 在所有 Java 提交中击败了92.72%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了5.15%的用户
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {

        int l = 0, r = nums.length - 1;  // 对撞指针
        while (l < r) {
            if (nums[l] + nums[r] == target) return new int[]{l + 1, r + 1};
            else if (nums[l] + nums[r] < target) l++;
            else r--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {-1, 0};
        int target = -1;
        int[] res = (new Solution3()).twoSum(numbers, target);
        Output.OutputBasicArray1D(res);
    }
}
