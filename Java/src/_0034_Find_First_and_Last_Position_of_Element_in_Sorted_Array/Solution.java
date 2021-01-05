package _0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import _0000_study._common.Output;

/**
 * Date: 2020/10/20 10:11
 * Content:
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.5 MB, 在所有 Java 提交中击败了90.59%的用户
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) return new int[]{-1, -1};

        int p = -1;  // nums 中其中某个 target 所在的位置
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                p = mid;
                break;
            }

            if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        // 不存在 target
        if (p == -1) return new int[]{-1, -1};

        // 以 p 为中心，寻找 target 的范围 (start, end)
        int start = p - 1, end = p + 1;
        while (start >= 0 && nums[start] == target) start--;
        while (end < nums.length && nums[end] == target) end++;
        return new int[]{start + 1, end - 1};
    }

    public static void main(String[] args) {

//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {8, 8, 8, 8};
        int target = 8;
        int[] res = (new Solution()).searchRange(nums, target);

        Output.OutputBasicArray1D(res);
    }
}
