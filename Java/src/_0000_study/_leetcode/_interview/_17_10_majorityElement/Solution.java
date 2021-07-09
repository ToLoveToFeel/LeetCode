package _0000_study._leetcode._interview._17_10_majorityElement;

import java.util.HashMap;

/**
 * Date: 2021/7/9 9:27
 * Content:
 * 执行用时：11 ms, 在所有 Java 提交中击败了24.51%的用户
 * 内存消耗：43.7 MB, 在所有 Java 提交中击败了48.94%的用户
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();  // (数据，次数)
        for (int x : nums) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        for (int k : cnt.keySet())
            if (cnt.get(k) > n / 2)
                return k;
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println((new Solution()).majorityElement(nums));  // 5
    }
}
