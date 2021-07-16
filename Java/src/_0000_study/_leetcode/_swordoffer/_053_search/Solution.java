package _0000_study._leetcode._swordoffer._053_search;

/**
 * Date: 2021/7/16 9:45
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了72.79%的用户
 */
public class Solution {

    public int search(int[] nums, int target) {

        if (nums.length == 0) return 0;

        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }

        if (nums[l] != target) return 0;
        int L = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return r - L + 1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println((new Solution()).search(nums, 8));  // 2
    }
}
