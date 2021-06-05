package _0462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

/**
 * Date: 2021/6/5 20:39
 * 执行用时：3 ms, 在所有 Java 提交中击败了83.54%的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了67.36%的用户
 */
public class Solution {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) res += nums[i] - nums[i / 2];  // i / 2写法也是可以的
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println((new Solution()).minMoves2(nums));  // 2
    }
}
