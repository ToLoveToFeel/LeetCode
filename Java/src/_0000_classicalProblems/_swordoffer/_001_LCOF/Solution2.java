package _0000_classicalProblems._swordoffer._001_LCOF;

import java.util.HashSet;

/**
 * Date: 2020/9/5 21:34
 * Content:
 */
class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num]++;
            if (count[num] > 1)
                return num;
        }

        throw new IllegalArgumentException("输入不合法");
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println((new Solution2()).findRepeatNumber(nums));
    }
}
