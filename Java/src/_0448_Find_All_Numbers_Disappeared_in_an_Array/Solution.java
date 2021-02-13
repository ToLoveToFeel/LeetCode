package _0448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2021/2/13 8:57
 * Content: 思路：如果x在数组中出现，将nums[x - 1]标为负数
 * 执行用时：6 ms, 在所有 Java 提交中击败了88.16%的用户
 * 内存消耗：47.3 MB, 在所有 Java 提交中击败了54.03%的用户
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int x : nums) {
            x = Math.abs(x);
            if (nums[x - 1] > 0) nums[x - 1] *= -1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++)
            if (nums[i - 1] > 0)
                res.add(i);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println((new Solution()).findDisappearedNumbers(nums));
    }
}
