package _0327_Count_of_Range_Sum;

/**
 * Date: 2020/11/7 15:55
 * Content:
 * 执行用时：188 ms, 在所有 Java 提交中击败了15.33%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了91.46%的用户
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper)
            return 0;

        // 第一步：计算数组前缀和。 sum[i] : 表示nums[0..i)数据之和
        // nums[i...j] : sum[j+1] - sum[i]
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        // 第二步：双重遍历，验证符合条件的区间
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long rangeSum = sum[j + 1] - sum[i];
                if (lower <= rangeSum && rangeSum <= upper)
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 5, -1};  // 3
//        int lower = -2;
//        int upper = 2;
//        int[] nums = {-1, 1};  // 1
//        int lower = 0;
//        int upper = 0;
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};  // 3
        int lower = -564;
        int upper = 3864;
        System.out.println((new Solution()).countRangeSum(nums, lower, upper));
    }
}
