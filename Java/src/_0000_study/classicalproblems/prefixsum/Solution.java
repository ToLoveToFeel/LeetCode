package _0000_study.classicalproblems.prefixsum;

public class Solution {

    static class NumArray {

        // sum[i] : sum(nums[0...i-1])
        private int[] sum;  // sum[i]存储前i个元素和， sum[0] = 0

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            // nums[i] + ... + num[j]
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(2, 3));  // -2
    }
}
