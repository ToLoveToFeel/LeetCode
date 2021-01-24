package _0217_Contains_Duplicate;

import java.util.HashSet;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 执行用时：8 ms, 在所有 Java 提交中击败了55.15%的用户
 * 内存消耗：44.5 MB, 在所有 Java 提交中击败了42.04%的用户
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> record = new HashSet<>();
        for (int num : nums) {
            if (record.contains(num)) return true;
            record.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println((new Solution()).containsDuplicate(nums));
    }
}