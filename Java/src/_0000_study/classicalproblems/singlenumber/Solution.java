package _0000_study.classicalproblems.singlenumber;

/**
 * Date: 2020/8/24 14:20
 * Content:
 */
public class Solution {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println((new Solution()).singleNumber(nums));
    }
}
