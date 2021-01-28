package _0137_Single_Number_II;

/**
 * Date: 2021/1/28 11:20
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了73.64%的用户
 */
public class Solution {

    public int singleNumber(int[] nums) {

        int two = 0, one = 0;
        for (int x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2 ,1, 2};
        System.out.println((new Solution()).singleNumber(nums));
    }
}
