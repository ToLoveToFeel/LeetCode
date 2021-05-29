package _0560_Subarray_Sum_Equals_K;

import java.util.HashMap;

/**
 * Date: 2021/5/29 14:24
 * 执行用时：19 ms, 在所有 Java 提交中击败了99.62%的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了29.58%的用户
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += hash.getOrDefault(s[i] - k, 0);
            hash.put(s[i], hash.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).subarraySum(new int[]{1, 1, 1}, 2));  // 2
    }
}
