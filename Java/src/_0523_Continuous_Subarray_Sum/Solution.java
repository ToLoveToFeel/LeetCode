package _0523_Continuous_Subarray_Sum;

import java.util.HashSet;

/**
 * Date: 2020/12/19 15:54
 * Content: 前缀和 + 哈希表
 * sum[i] : 代表num[0...i-1]数据的和
 * 对于某个 i，判断 sum[i] - sum[i-2], sum[i] - sum[i-3], ... , sum[i] - sum[0]是否存在k的倍数即可
 * 相当于判断sum[i]和sum[k]是否同余即可(0<= k <=i-2)，用哈希表
 * <p>
 * 执行用时：3 ms, 在所有 Java 提交中击败了98.97%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了90.34%的用户
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            hash.add(s[i - 2] % k);
            if (hash.contains(s[i] % k)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        System.out.println((new Solution()).checkSubarraySum(nums, 6));  // true
    }
}
