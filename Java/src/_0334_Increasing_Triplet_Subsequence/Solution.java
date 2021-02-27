package _0334_Increasing_Triplet_Subsequence;

import java.util.Arrays;

/**
 * Created by WXX on 2021/2/27 9:55
 * 执行用时：1 ms, 在所有 Java 提交中击败了51.05%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了22.57%的用户
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {

        int[] q = new int[2];
        Arrays.fill(q, Integer.MAX_VALUE);
        for (int x : nums) {
            int k = 2;
            while (k > 0 && q[k - 1] >= x) k--;  // 找到小于x的最大的数
            if (k == 2) return true;
            q[k] = x;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).increasingTriplet(new int[]{1, 2, 3, 4, 5}));  // true
    }
}
