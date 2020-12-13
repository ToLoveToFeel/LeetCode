package _0220_Contains_Duplicate_III;

import java.util.TreeSet;

/**
 * 时间复杂度：O(n*logn)
 * 空间复杂度：O(k)
 */
class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0)
            return false;

        TreeSet<Long> record = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num1 = (long) nums[i] - (long) t;
            long num2 = (long) nums[i] + (long) t;

            // record.ceiling(num1) : 返回大于或等于 num1 的最小键
            if (record.ceiling(num1) != null && record.ceiling(num1) <= num2)
                return true;

            record.add((long) nums[i]);

            if (record.size() == k + 1)  // 保证滑动窗口长度始终为k，有k+1个元素
                record.remove((long) nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println((new Solution()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
