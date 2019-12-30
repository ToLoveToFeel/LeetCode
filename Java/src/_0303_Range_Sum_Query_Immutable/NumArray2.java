package _0303_Range_Sum_Query_Immutable;

class NumArray2 {

    private int[] sum;  // sum[i]存储前i个元素和， sum[0] = 0

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
