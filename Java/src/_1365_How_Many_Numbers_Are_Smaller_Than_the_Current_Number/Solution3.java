package _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: 2020/10/26 8:39
 * Content:
 * 快速排序
 * 9 ms, 在所有 Java 提交中击败了63.00%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了83%的用户
 */
public class Solution3 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;  // nums[i] 在原本数组中的索引
        }

//        Arrays.sort(data, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        Arrays.sort(data, Comparator.comparingInt((int[] o) -> o[0]));

        int[] res = new int[nums.length];
        int count = -1;
        for (int i = 0; i < n; i++) {
            if (count == -1 || data[i][0] != data[i - 1][0])
                count = i;
            int index = data[i][1];
            res[index] = count;  // nums[index] 前有 count 个不相等的元素
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 1, 2, 2, 3};
        int[] nums = {6, 5, 4, 8};
//        int[] nums = {7, 7, 7, 7};
        int[] res = (new Solution3()).smallerNumbersThanCurrent(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
