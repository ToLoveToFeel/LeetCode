package _0035_Search_Insert_Position;

/**
 * Date: 2020/9/18 15:15
 * Content: 二分查找
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target == nums[mid]) return mid;

            if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println((new Solution()).searchInsert(nums, target));
    }
}
