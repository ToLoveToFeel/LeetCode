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
        if (nums == null || nums.length == 0 || lower > upper)
            return 0;

        // 第一步：计算前缀和。 sum[i] : 表示nums[0..i)数据之和
        // nums[i...j] : sum[j+1] - sum[i]
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        /*
            对于每个下标 index, 以 index 为右端点的满足题意的下标对的数量 = sum[0...index-1]中这index个数满足
            出现在区间[sum[index]-upper, sum[index]-lower]的数据的数量

            这是因为，比如 0 <= k < index, lower <= sum[index]-sum[k](nums[k...index-1]) <= upper
            那么：sum[index]-upper <= sum[k] <= sum[index]-lower
         */
        Set<Long> set = new HashSet<>();
        for (long s : sum) {
            set.add(s);
            set.add(s - upper);
            set.add(s - lower);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> map = new HashMap<>();
        int id = 0;
        for (Long x : set) {
            map.put(x, id++);
        }

        return 0;
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
        System.out.println((new Solution2()).countRangeSum(nums, lower, upper));
    }
}
