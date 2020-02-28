package _0053_Maximum_Subarray;

public class Solution3 {
    // 分治解法
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return rec(nums, 0, nums.length - 1);
    }

    // 返回[L...R]之间的最大子序和
    private int rec(int[] arr, int L, int R) {
        if (L == R)
            return arr[L];
        int mid = L + (R - L) / 2;
        int LMax = rec(arr, L, mid);  // 求出左边部分从右开始的最大值
        int RMax = rec(arr, mid + 1, R);  // 求出右边部分从左开始的最大值

        int sum = 0, LSumMax = Integer.MIN_VALUE, RSumMax = Integer.MIN_VALUE;

        for (int i = mid; i >= L; i--) {
            sum += arr[i];
            if (sum > LSumMax) {
                LSumMax = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= R; i++) {
            sum += arr[i];
            if (sum > RSumMax) {
                RSumMax = sum;
            }
        }
        int crossMax = LSumMax + RSumMax;

        //compare crossMax、LMax,RMax
        if (LMax >= RMax && LMax >= crossMax)
            return LMax;
        if (RMax >= LMax && RMax >= crossMax)
            return RMax;
        return crossMax;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,-1,-3,4,-1,2,1,-5,4};
        System.out.println((new Solution3()).maxSubArray(nums));
    }
}
