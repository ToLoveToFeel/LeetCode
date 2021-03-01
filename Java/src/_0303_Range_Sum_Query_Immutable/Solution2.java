package _0303_Range_Sum_Query_Immutable;

/**
 * 前缀和
 * 执行用时：10 ms, 在所有 Java 提交中击败了77.14%的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了60.70%的用户
 */
public class Solution2 {

    static class NumArray {

        private int[] s;  // sum[i]存储前i个元素和， sum[0] = 0

        public NumArray(int[] nums) {

            s = new int[nums.length + 1];
            s[0] = 0;
            for (int i = 1; i < s.length; i++) s[i] = s[i - 1] + nums[i - 1];
        }

        public int sumRange(int i, int j) {
            i++;
            j++;
            return s[j] - s[i - 1];
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(2, 3));  // -2
    }
}
