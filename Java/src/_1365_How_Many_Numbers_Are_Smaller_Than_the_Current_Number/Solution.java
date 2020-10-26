package _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

/**
 * Date: 2020/10/26 8:39
 * Content:
 * 暴力解法：O(n^2)  n = nums.length
 * 执行用时：14 ms, 在所有 Java 提交中击败了57.40%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了96.85%的用户
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i])
                    count++;
            }
            res[i] = count;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 1, 2, 2, 3};
//        int[] nums = {6, 5, 4, 8};
        int[] nums = {7, 7, 7, 7};
        int[] res = (new Solution()).smallerNumbersThanCurrent(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
