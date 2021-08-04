package _0611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * Date: 2021/8/4 10:27
 * Content:
 */
public class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i - 1, k = 0; j >= 0 && k < j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) k++;
                res += j - k;
            }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 4};
        System.out.println((new Solution()).triangleNumber(nums));  // 3
    }
}
