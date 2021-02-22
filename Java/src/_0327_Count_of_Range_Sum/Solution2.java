package _0327_Count_of_Range_Sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2020/11/7 15:55
 * Content: 使用线段树解决
 * 未完待续......
 */
public class Solution2 {
    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        if (n == 0 || lower > upper) return 0;

        // 第一步：计算前缀和
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        /*
            对于每个下标 i, 以 i 为右端点的满足题意的下标对的数量 = sum[0...i-1]中这 i 个数满足
            出现在区间[sum[i]-upper, sum[i]-lower]的数据的数量
            这是因为，比如 0 <= k < i, lower <= sum[i]-sum[k] (nums[k...i-1]) <= upper
            那么：sum[i]-upper <= sum[k] <= sum[i]-lower
         */
        Set<Long> set = new HashSet<>();
        for (long t : s) {
            set.add(t);
            set.add(t - upper);
            set.add(t - lower);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> map = new HashMap<>();
        int id = 0;
        for (Long x : set) map.put(x, id++);
        return 0;
    }

    public static void main(String[] args) {

//        int[] nums = {-2, 5, -1};  // 3
//        int lower = -2, upper = 2;

//        int[] nums = {-1, 1};  // 1
//        int lower = 0, upper = 0;

        int[] nums = {-2147483647, 0, -2147483647, 2147483647};  // 3
        int lower = -564, upper = 3864;

        System.out.println((new Solution2()).countRangeSum(nums, lower, upper));
    }
}
