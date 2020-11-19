package _0283_Move_Zeroes;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了74.10%的用户
 */

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
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
