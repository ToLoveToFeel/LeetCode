package _0053_Maximum_Subarray;

public class Solution3 {

    // 返回[l...r]之间的最大子序和
    private int rec(int[] arr, int l, int r) {

        if (l == r)
            return arr[l];
        int mid = l + (r - l) / 2;
        int lMax = rec(arr, l, mid);  // 求出左边部分从右开始的最大值
        int rMax = rec(arr, mid + 1, r);  // 求出右边部分从左开始的最大值

        int sum = 0, lSumMax = Integer.MIN_VALUE, rSumMax = Integer.MIN_VALUE;

        for (int i = mid; i >= l; i--) {
            sum += arr[i];
            if (sum > lSumMax) {
                lSumMax = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= r; i++) {
            sum += arr[i];
            if (sum > rSumMax) {
                rSumMax = sum;
            }
        }
        int crossMax = lSumMax + rSumMax;

        // compare crossMax、LMax,RMax
        if (lMax >= rMax && lMax >= crossMax)
            return lMax;
        if (rMax >= lMax && rMax >= crossMax)
            return rMax;
        return crossMax;
    }

    // 分治解法
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        return rec(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, -1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println((new Solution3()).maxSubArray(nums));
    }
}
