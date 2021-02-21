package _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

import java.util.TreeMap;

/**
 * Date: 2021/2/21 9:52
 * Content: Java中的TreeSet不能放入重复元素
 * 执行用时：76 ms, 在所有 Java 提交中击败了35.04%的用户
 * 内存消耗：56 MB, 在所有 Java 提交中击败了55.31%的用户
 */
public class Solution {

    public int longestSubarray(int[] nums, int limit) {

        TreeMap<Integer, Integer> s = new TreeMap<>();  // (数据，出现次数)
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            s.put(nums[i], s.getOrDefault(nums[i], 0) + 1);
            while (s.lastKey() - s.firstKey() > limit)
                if (s.get(nums[j]) == 1) s.remove(nums[j++]);
                else s.put(nums[j], s.get(nums[j++]) - 1);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).longestSubarray(new int[]{8, 2, 4, 7}, 4));  // 2
        System.out.println((new Solution()).longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));  // 4
        System.out.println((new Solution()).longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));  // 3
    }
}
