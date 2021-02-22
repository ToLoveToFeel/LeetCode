package _0327_Count_of_Range_Sum;

/**
 * Date: 2020/11/7 15:55
 * Content:
 * 执行用时：208 ms, 在所有 Java 提交中击败了7.77%的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了54.19%的用户
 */
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        if (n == 0 || lower > upper) return 0;

        // 第一步：计算前缀和
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        // 第二步：双重遍历，验证符合条件的区间
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                long t = s[j] - s[i - 1];
                if (lower <= t && t <= upper)
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        int[] nums = {-2, 5, -1};  // 3
//        int lower = -2, upper = 2;

//        int[] nums = {-1, 1};  // 1
//        int lower = 0, upper = 0;

        int[] nums = {-2147483647, 0, -2147483647, 2147483647};  // 3
        int lower = -564, upper = 3864;

        System.out.println((new Solution()).countRangeSum(nums, lower, upper));
    }
}
