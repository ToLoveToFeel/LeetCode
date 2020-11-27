package _0303_Range_Sum_Query_Immutable;

public class Solution2 {

    static class NumArray {

        private int[] sum;  // sum[i]存储前i个元素和， sum[0] = 0

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(2, 3));  // -2
    }
}
