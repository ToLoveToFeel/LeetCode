package _0453_Minimum_Moves_to_Equal_Array_Elements;

import java.util.Arrays;

/**
 * Date: 2021/6/4 10:18
 * 执行用时：10 ms, 在所有 Java 提交中击败了41.17%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了97.21%的用户
 */
public class Solution {

    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.length;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).minMoves(new int[]{1, 2, 3}));  // 3
    }
}
