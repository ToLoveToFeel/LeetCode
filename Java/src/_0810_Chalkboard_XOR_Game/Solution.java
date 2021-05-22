package _0810_Chalkboard_XOR_Game;

/**
 * Date: 2021/5/22 9:33
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了93.90%的用户
 */
public class Solution {

    public boolean xorGame(int[] nums) {
        int s = 0;
        for (int x : nums) s ^= x;
        return s == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        System.out.println((new Solution()).xorGame(nums));  // false
    }
}
