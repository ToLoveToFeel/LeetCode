package _0001_Two_Sum;

import java.util.HashMap;

/**
 * 哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                return new int[]{i, record.get(complement)};
            }
            record.put(nums[i], i);
        }

        throw new IllegalArgumentException("the input has no solution!");
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = (new Solution2()).twoSum(nums, target);
        for (int num : res)
            System.out.println(num);
    }
}
