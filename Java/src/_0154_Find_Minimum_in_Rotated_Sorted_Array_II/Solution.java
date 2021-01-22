package _0154_Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * Date: 2021/1/22 16:05
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了35.56%的用户
 */
public class Solution {

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r && nums[l] == nums[r]) r--;
        if (nums[l] < nums[r]) return nums[l];
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }

    public static void main(String[] args) {

//        int[] nums = {2, 2, 2, 0, 1};  // 0
        int[] nums = {1, 2, 3, 1};  // 1
        System.out.println((new Solution()).findMin(nums));
    }
}
