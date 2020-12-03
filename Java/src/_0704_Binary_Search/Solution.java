package _0704_Binary_Search;

/**
 * Date: 2020/9/21 9:08
 * Content:
 */
public class Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            if (target == nums[mid])
                return mid;

            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println((new Solution()).search(nums, target));
    }
}
