package _0268_Missing_Number;

/**
 * Date: 2021/2/2 19:30
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了70.40%的用户
 */
public class Solution {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int x : nums) res -= x;
        return res;
    }

    public static void main(String[] args) {

        int[]  nums = {3, 0, 1};
        System.out.println((new Solution()).missingNumber(nums));  // 2
    }
}
