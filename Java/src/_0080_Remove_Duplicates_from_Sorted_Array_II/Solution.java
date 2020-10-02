package _0080_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;

        int k = 2;  // [0...k)中的元素均为去重后的元素

        for (int i = 2; i < nums.length; i++)
            if (nums[i] != nums[k - 2])
                nums[k++] = nums[i];

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println((new Solution()).removeDuplicates(nums));
    }
}
