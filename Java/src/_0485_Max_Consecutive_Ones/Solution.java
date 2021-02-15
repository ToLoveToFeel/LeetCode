package _0485_Max_Consecutive_Ones;

/**
 * Date: 2020/9/20 21:28
 * Content:
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了22.24%的用户
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {  // 滑动窗口：[i...j)
            if (nums[i] == 0) continue;
            int j = i + 1;
            while (j < nums.length && nums[j] == 1) j++;
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {0, 0, 0};
//        int[] nums = {1};
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println((new Solution()).findMaxConsecutiveOnes(nums));
    }
}
