package _0000_study._algorithm.binarysearch;

/**
 * Date: 2020/9/18 15:18
 * Content:
 */
public class Solution {
    public int binarySearch(int[] nums, int target) {

        int l = 0, r = nums.length - 1;  // 在 [l...r] 的范围内寻找 target
        while (l <= r) {  // 在 l == r 时，区间 [l...r] 依然是有效的
            int mid = (r - l) / 2 + l;
            if (target == nums[mid])
                return mid;

            if (target > nums[mid])
                l = mid + 1;  // target 在 [mid+1...r] 中
            else // target < nums[mid]
                r = mid - 1;  // target 在 [l...mid-1] 中
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println((new Solution()).binarySearch(nums, target));
    }
}
