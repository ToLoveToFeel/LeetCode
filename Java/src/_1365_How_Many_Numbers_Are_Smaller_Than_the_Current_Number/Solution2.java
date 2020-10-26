package _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import java.util.Arrays;

/**
 * Date: 2020/10/26 8:39
 * Content:
 * 暴力解法：O(n^2)  n = nums.length
 * 优化Solution 利用哈希表，记录已经得到的结果的数据
 * 执行用时：5 ms, 在所有 Java 提交中击败了69.49%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了96.94%的用户
 */
public class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] memo = new int[101];  // 记录某个数字 该数组中小于它的数的个数
        Arrays.fill(memo, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];  // 当前考察的数字
            if (memo[num] != -1){
                res[i] = memo[num];
                continue;
            }
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < num)
                    count++;
            }
            res[i] = count;
            memo[num] = count;
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 1, 2, 2, 3};
//        int[] nums = {6, 5, 4, 8};
        int[] nums = {7, 7, 7, 7};
        int[] res = (new Solution2()).smallerNumbersThanCurrent(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
