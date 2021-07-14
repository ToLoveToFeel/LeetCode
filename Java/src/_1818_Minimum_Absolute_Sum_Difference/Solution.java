package _1818_Minimum_Absolute_Sum_Difference;

import java.util.TreeSet;

/**
 * Date: 2021/7/14 10:11
 * Content:
 */
public class Solution {

    static final int mod = (int) (1e9) + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> a = new TreeSet<>();
        for (int x : nums1) a.add(x);
        int sum = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + t) % mod;
            if (a.ceiling(nums2[i]) != null)
                d = Math.max(d, t - Math.abs(a.ceiling(nums2[i]) - nums2[i]));
            if (a.floor(nums2[i]) != null)
                d = Math.max(d, t - Math.abs(a.floor(nums2[i]) - nums2[i]));
        }
        return (sum - d + mod) % mod;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 28, 21};
        int[] nums2 = {9, 21, 20};
        System.out.println((new Solution()).minAbsoluteSumDiff(nums1, nums2));  // 9
    }
}
