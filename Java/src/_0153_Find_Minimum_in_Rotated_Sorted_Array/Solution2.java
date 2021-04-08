package _0153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * Date: 2020/9/24 13:42
 * Content: 二分
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了5.04%的用户
 */
public class Solution2 {

    public int findMin(int[] nums) {

        int n = nums.length - 1;
        if (nums[n] >= nums[0]) return nums[0];  // 说明未旋转

        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        return nums[r + 1];
    }

    public static void main(String[] args) {

//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {3, 1, 2};
//        int[] nums = {3, 1};
//        int[] nums = {3, 4, 1};
//        int[] nums = {4, 5, 1, 2, 3};
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println((new Solution2()).findMin(nums));
    }
}
