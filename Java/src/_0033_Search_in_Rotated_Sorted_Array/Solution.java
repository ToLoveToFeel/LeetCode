package _0033_Search_in_Rotated_Sorted_Array;

/**
 * Date: 2020/9/13 20:45
 * Content:
 * 二分查找法
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 核心思想：在有序的一遍查询是否存在target，如果不存在，去无序的一遍查询target
        int left = 0, right = nums.length - 1;  // 在[left...right]中搜索target，关键要确保target在[left...right]之中
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[left]) {  // 左半边有序
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {  // 右半边有序
                if (nums[right] >= target && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println((new Solution()).search(nums, target));
    }
}
