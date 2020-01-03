package _0001_Two_Sum;

import java.util.HashMap;

public class Solution2 {
    // One-Pass Hash Table
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (record.containsKey(complement)){
                int[] res = {i, record.get(complement)};
                return res;
            }

            record.put(nums[i], i);
        }

        throw new IllegalArgumentException("the input has no solution!");
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] res = new int[2];

        res = (new Solution2()).twoSum(numbers, target);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
