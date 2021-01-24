package _0219_Contains_Duplicate_II;

/**
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i > k) break;
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println((new Solution()).containsNearbyDuplicate(nums, k));
    }
}
