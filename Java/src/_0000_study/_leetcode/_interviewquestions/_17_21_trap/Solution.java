package _0000_study._leetcode._interviewquestions._17_21_trap;

/**
 * Created by WXX on 2021/3/23 10:45
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了55.81%的用户
 */
public class Solution {

    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] left_max = new int[n], right_max = new int[n];

        left_max[0] = height[0];
        for (int i = 1; i < n; i++) left_max[i] = Math.max(left_max[i - 1], height[i]);
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) right_max[i] = Math.max(right_max[i + 1], height[i]);

        int res = 0;
        for (int i = 0; i < n; i++) res += Math.min(left_max[i], right_max[i]) - height[i];

        return res;
    }

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println((new Solution()).trap(height));  // 6
    }
}
