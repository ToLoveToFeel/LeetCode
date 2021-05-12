package _0376_Wiggle_Subsequence;

/**
 * Date: 2020/12/12 15:01
 * Content: 动态规划
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了79.50%的用户
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {

        int up = 0, down = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i - 1] < nums[i]) up = down + 1;
            else if (nums[i - 1] > nums[i]) down = up + 1;
        return Math.max(up, down) + 1;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 7, 4, 9, 2, 5};  // 6
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};  // 7
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // 2
        int[] nums = {0, 0};  // 1
        System.out.println((new Solution()).wiggleMaxLength(nums));
    }
}
