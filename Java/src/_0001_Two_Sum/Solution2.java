package _0001_Two_Sum;

import _0000_study._common.Output;

import java.util.HashMap;

/**
 * 哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();  // (元素，元素对应下标)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hash.containsKey(complement)) {
                return new int[]{i, hash.get(complement)};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("the input has no solution!");
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = (new Solution2()).twoSum(nums, target);

        Output.OutputBasicArray1D(res);
    }
}
