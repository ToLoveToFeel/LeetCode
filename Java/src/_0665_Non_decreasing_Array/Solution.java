package _0665_Non_decreasing_Array;

/**
 * Date: 2021/2/7 10:43
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.54%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了48.63%的用户
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {

        int n = nums.length;
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                if (!flag) return false;
                if (i > 1 && i < n - 1 && nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1])
                    return false;
                flag = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 3};
        System.out.println((new Solution()).checkPossibility(nums));  // true
    }
}
