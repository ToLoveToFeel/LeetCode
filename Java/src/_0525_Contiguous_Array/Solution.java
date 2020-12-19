package _0525_Contiguous_Array;

import java.util.HashMap;

/**
 * Date: 2020/12/19 16:30
 * Content: 使用哈希表存储
 * sum[i] : 代表num[0...i-1]中 1的个数减去0的个数
 * 对于某个 i，寻找 sum[i] - sum[i-1], sum[i] - sum[i-2], ... , sum[i] - sum[0]中为0的最小下标，更新结果
 * <p>
 * 为什么为0呢？比如sum[i] - sum[i-k] = 0
 * ==> (one2 - zero2) - (one1 - zero1) = 0 ==> (one2 - one1) == (zero2 - zero1)
 * 说明在区间[i-k...i-1]中0和1的个数相等，区间长度为 i - (i-k) = k
 * <p>
 * 执行用时：27 ms, 在所有 Java 提交中击败了63.52%的用户
 * 内存消耗：48 MB, 在所有 Java 提交中击败了63.33%的用户
 */
public class Solution {

    public int findMaxLength(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();  // (sum[i], sum[i]出现的最小下标i)
        map.put(0, 0);  // sum[0] = 0
        int res = 0;
        for (int i = 1, one = 0, zero = 0; i <= n; i++) {

            int num = nums[i - 1];
            if (num == 0)
                zero++;
            else
                one++;
            int sum = one - zero;  // sum[i]

            if (map.containsKey(sum))  // 说明 sum[i] - sum[k] = 0, (sum[k], k)为之前存储进去的数据
                res = Math.max(res, i - map.get(sum));
            else
                map.put(sum, i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 0, 1, 1};
        System.out.println((new Solution()).findMaxLength(nums));
    }
}
