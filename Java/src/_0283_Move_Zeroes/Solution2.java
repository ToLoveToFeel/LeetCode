package _0283_Move_Zeroes;

public class Solution2 {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void moveZeroes(int[] nums) {

        int k = 0;  // nums中，[0...k)的元素均为非零元素

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[k++] = nums[i];

        for (int i = k; i < nums.length; i++)
            nums[i] = 0;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        (new Solution2()).moveZeroes(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
