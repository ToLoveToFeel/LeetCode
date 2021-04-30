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

        int i = 0, j = nums.length - 1;  // 对撞指针
        while (i < j) {
            if (nums[i] + nums[j] == target) return new int[]{i + 1, j + 1};
            if (nums[i] + nums[j] < target) i++;
            else j--;
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
