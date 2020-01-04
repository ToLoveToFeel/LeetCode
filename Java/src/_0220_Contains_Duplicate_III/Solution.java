package _0220_Contains_Duplicate_III;

import java.util.TreeSet;

class Solution {
    // 时间复杂度：O(n*logn)
    // 空间复杂度：O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;

        TreeSet<Long> record = new TreeSet<>();

        for (int i = 0; i < nums.length; i++){
            if (record.ceiling((long)nums[i] - (long)t) != null &&
                    record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
                return true;

            record.add((long)nums[i]);

            if (record.size() == k + 1)  // 保证滑动窗口长度始终为k，有k+1个元素
                record.remove((long)nums[i-k]);
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
