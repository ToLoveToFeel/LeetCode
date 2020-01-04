package _0219_Contains_Duplicate_II;

import java.util.HashSet;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (record.contains(nums[i]))
                return true;

            record.add(nums[i]);

            if (record.size() == k + 1)  // 保证滑动窗口长度始终为k，有k+1个元素
                record.remove(nums[i-k]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        System.out.println((new Solution2()).containsNearbyDuplicate(nums, k));
    }
}
