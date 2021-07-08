package _0930_Binary_Subarrays_With_Sum;

import java.util.HashMap;

/**
 * Date: 2021/7/8 9:29
 * Content:
 * 执行用时：17 ms, 在所有 Java 提交中击败了71.62%的用户
 * 内存消耗：43.3 MB, 在所有 Java 提交中击败了9.54%的用户
 */
public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            res += cnt.getOrDefault(s[i] - goal, 0);
            cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 0, 1};
        System.out.println((new Solution()).numSubarraysWithSum(nums, 2));  // 4
    }
}
