package _0000_study._leetcode._swordoffer._003_findRepeatNumber;

import java.util.HashSet;

/**
 * Date: 2020/9/5 21:34
 * Content:
 */
class Solution {

    public int findRepeatNumber(int[] nums) {

        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums)
            if (!hash.contains(num)) hash.add(num);
            else return num;

        throw new IllegalArgumentException("输入不合法");
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println((new Solution()).findRepeatNumber(nums));
    }
}
