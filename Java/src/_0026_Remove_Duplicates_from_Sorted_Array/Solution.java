package _0026_Remove_Duplicates_from_Sorted_Array;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：1 ms, 在所有 Java 提交中击败了83.16%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了72.84%的用户
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (i == 0 || nums[i] != nums[i - 1])
                nums[j++] = nums[i];
        // nums[0] ~ num[j - 1] 所有a中不重复的数
        return j;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println((new Solution()).removeDuplicates(nums));
    }
}

/*
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1;  // [0...k)中的元素均为去重后的元素
        int removeValue = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != removeValue) {
                nums[k++] = nums[i];
                removeValue = nums[i];
            }

        return k;
    }
 */
