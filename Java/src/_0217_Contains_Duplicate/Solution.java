package _0217_Contains_Duplicate;

import java.util.HashSet;

class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> record = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (record.contains(nums[i]))
                return true;
            record.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println((new Solution()).containsDuplicate(nums));
    }
}