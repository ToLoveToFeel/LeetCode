package _0000_study.classicalproblems.majorityelement;

/**
 * Date: 2020/8/24 14:54
 * Content: 暴力解法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int majorityElement(int[] nums) {

        int res = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                res = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println((new Solution()).majorityElement(nums));
    }
}
