package _0136_Single_Number;

/**
 * Date: 2020/8/24 14:20
 * Content:
 */
public class Solution {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println((new Solution()).singleNumber(nums));
    }
}
