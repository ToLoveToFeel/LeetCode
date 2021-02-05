package _0287_Find_the_Duplicate_Number;

/**
 * Date: 2021/2/5 8:58
 * Content:
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了54.60%的用户
 */
public class Solution {

    public int findDuplicate(int[] nums) {

        int a = 0, b = 0;
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                a = 0;
                while (a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};
        System.out.println((new Solution()).findDuplicate(nums));
    }
}
