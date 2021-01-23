package _0080_Remove_Duplicates_from_Sorted_Array_II;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    public int removeDuplicates(int[] nums) {

        int i = 0, j = 0;
        while (j < nums.length) {
            int k = nextIndex(nums, j);
            int len = Math.min(2, k - j);
            for (int ii = 0; ii < len; ii++)
                nums[i + ii] = nums[j];

            i += len;
            j = k;
        }

        return i;
    }

    private int nextIndex(int[] nums, int index) {
        for (int i = index; i < nums.length; i++)
            if (nums[i] != nums[index])
                return i;
        return nums.length;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println((new Solution2()).removeDuplicates(nums));
    }
}
